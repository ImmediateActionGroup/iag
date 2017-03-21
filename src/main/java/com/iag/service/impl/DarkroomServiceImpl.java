package com.iag.service.impl;

import com.iag.enums.DarkroomStatus;
import com.iag.exception.enums.ExceptionEnum;
import com.iag.exception.ex.BusinessException;
import com.iag.exception.ex.DataBaseException;
import com.iag.model.IagDarkroom;
import com.iag.model.IagUser;
import com.iag.service.DarkroomService;
import com.iag.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void removeDarkroom(Integer drid, String abortReason) throws BusinessException {
        IagDarkroom darkroom = queryById(drid);
        if(darkroom != null){
            darkroom.setStatus(DarkroomStatus.OUT_ROOM.value());
            darkroom.setEndTime(new Date());
            darkroom.setAbortReason(abortReason);
            baseDAO.update(darkroom);
        }else{
            throw new BusinessException(ExceptionEnum.DARKROOM_NOT_EXIST);
        }
    }

    public IagDarkroom addDarkroom(Integer uid, Integer days, String reason) throws BusinessException {
        IagUser user = userService.queryById(uid);
        if(user != null){
            IagDarkroom darkroom = new IagDarkroom();
            darkroom.setUser(user);
            darkroom.setDarkTime(days);
            darkroom.setBeginTime(new Date());
            darkroom.setStatus(DarkroomStatus.IN_ROOM.value());
            darkroom.setReason(reason);

            Integer newId = baseDAO.save(darkroom);
            return (IagDarkroom) baseDAO.queryById(com.iag.model.IagDarkroom.class, newId);
        }else {
            throw new BusinessException(ExceptionEnum.USER_NOT_EXIST);
        }
    }

    public List<IagDarkroom> queryAll() throws DataBaseException {
        return baseDAO.queryAll(com.iag.model.IagDarkroom.class);
    }

    public IagDarkroom queryById(Integer drid) throws DataBaseException {
        return (IagDarkroom) baseDAO.queryById(com.iag.model.IagDarkroom.class, drid);
    }
}
