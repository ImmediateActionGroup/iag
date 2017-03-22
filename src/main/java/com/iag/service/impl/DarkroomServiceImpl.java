package com.iag.service.impl;

import com.iag.enums.DarkroomStatus;
import com.iag.enums.ModelIsOrNot;
import com.iag.exception.enums.ExceptionEnum;
import com.iag.exception.ex.BusinessException;
import com.iag.exception.ex.DataBaseException;
import com.iag.model.IagDarkroom;
import com.iag.model.IagUser;
import com.iag.service.DarkroomService;
import com.iag.service.UserService;
import com.iag.util.db.Conditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 小黑屋
 * Created by beishan on 2017/3/21.
 */
@Service(value = "darkroomService")
public class DarkroomServiceImpl extends BaseService<IagDarkroom> implements DarkroomService {

    @Autowired
    private UserService userService;

    public void synoCheckDrStatus() throws DataBaseException {
        System.out.println("开始检查是否有应该刑满释放的人员-----------");

        List<IagDarkroom> checkDrs = queryAllByStatus(DarkroomStatus.IN_ROOM);
        int out_num = 0;
        if(checkDrs != null && checkDrs.size() > 0){
            for(IagDarkroom darkroom : checkDrs){
                if(isTimeUp(darkroom.getBeginTime(), darkroom.getDarkTime())){
                    removeDarkroom(darkroom);
                    out_num ++;
                }
            }
        }
        System.out.println("检查完毕--本次共释放  " + out_num + "人");
    }

    /**
     * 刑满释放
     * @param darkroom
     * @throws DataBaseException
     */
    private void removeDarkroom(IagDarkroom darkroom) throws DataBaseException{
        if(darkroom != null){
            darkroom.setStatus(DarkroomStatus.OUT_ROOM.value());
            darkroom.setEndTime(new Date());
            baseDAO.update(darkroom);
        }
    }

    public void removeDarkroom(Integer drid, String abortReason) throws BusinessException {
        IagDarkroom darkroom = queryById(drid);
        if(darkroom != null && darkroom.getStatus() != DarkroomStatus.OUT_ROOM.value()){
            darkroom.setStatus(DarkroomStatus.OUT_ROOM.value());
            darkroom.setEndTime(new Date());
            darkroom.setAbortReason(abortReason);
            darkroom.setIsAbort(ModelIsOrNot.IS.value());
            baseDAO.update(darkroom);
        }else{
            throw new BusinessException(ExceptionEnum.DARKROOM_NOT_EXIST);
        }
    }

    public IagDarkroom addDarkroom(Integer uid, Integer minutes, String reason) throws BusinessException {
        //查询要关进小黑屋的用户是否存在
        IagUser user = userService.queryById(uid);
        if(user != null){
            //查询该用户是否已经被关进小黑屋
            IagDarkroom darkroom = isInDarkroom(uid);
            Date nowDate = new Date();
            if(darkroom != null){
                //存在未过期判决，则是为过期判决失效
                darkroom.setIsAbort(ModelIsOrNot.IS.value());
                darkroom.setEndTime(nowDate);
                darkroom.setStatus(DarkroomStatus.OUT_ROOM.value());
                darkroom.setAbortReason("改判后当前判决失效");
                baseDAO.update(darkroom);
            }
            //添加新判决
            darkroom = new IagDarkroom();
            darkroom.setUser(user);
            darkroom.setDarkTime(minutes);
            darkroom.setBeginTime(nowDate);
            darkroom.setStatus(DarkroomStatus.IN_ROOM.value());
            darkroom.setReason(reason);
            darkroom.setIsAbort(ModelIsOrNot.NOT.value());
            Integer newId = baseDAO.save(darkroom);
            return (IagDarkroom) baseDAO.queryById(com.iag.model.IagDarkroom.class, newId);
        }else {
            throw new BusinessException(ExceptionEnum.USER_NOT_EXIST);
        }
    }


    /**
     * 检测某人关押的时间是否已经到期了
     * @param beginTime 开始的时间
     * @param lockTime 要关押的时间(分钟数)
     * @return
     * @throws DataBaseException 数据库异常
     */
    private boolean isTimeUp(Date beginTime, Integer lockTime) throws DataBaseException{
        Date nowDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowDate);
        long nowMills = calendar.getTimeInMillis();
        calendar.setTime(beginTime);
        long aimMills = calendar.getTimeInMillis() + lockTime * 60;
        if(nowMills > aimMills){
            return true;
        }
        return false;
    }

    private IagDarkroom isInDarkroom(Integer uid) throws DataBaseException{
        Conditions conditions = new Conditions();
        conditions.addCondition("user.id", uid, Conditions.Operator.EQUAL);
        conditions.addCondition("status", DarkroomStatus.IN_ROOM.value(), Conditions.Operator.EQUAL);
        List<IagDarkroom> dks = baseDAO.queryByConditions(com.iag.model.IagDarkroom.class, conditions);
        if(dks != null && dks.size() > 0){
            return dks.get(0);
        }
        return null;
    }

    public List<IagDarkroom> queryAll() throws DataBaseException {
        return baseDAO.queryAll(com.iag.model.IagDarkroom.class);
    }

    public IagDarkroom queryById(Integer drid) throws DataBaseException {
        return (IagDarkroom) baseDAO.queryById(com.iag.model.IagDarkroom.class, drid);
    }

    private List<IagDarkroom> queryAllByStatus(DarkroomStatus darkroomStatus) throws DataBaseException{
        Conditions conditions = new Conditions();
        conditions.addCondition("status", darkroomStatus.value(), Conditions.Operator.EQUAL);
        return baseDAO.queryByConditions(com.iag.model.IagDarkroom.class, conditions);
    }
}
