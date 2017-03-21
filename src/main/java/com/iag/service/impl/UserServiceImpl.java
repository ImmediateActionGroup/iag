package com.iag.service.impl;

import com.iag.enums.ModelIsDelete;
import com.iag.exception.enums.ExceptionEnum;
import com.iag.exception.ex.BusinessException;
import com.iag.exception.ex.DataBaseException;
import com.iag.model.IagRole;
import com.iag.model.IagUser;
import com.iag.model.IagUserconfig;
import com.iag.service.UserService;
import com.iag.util.SecurityTools;
import com.iag.util.db.Conditions;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by beishan on 2017/3/8.
 */
@Service("userService")
public class UserServiceImpl extends BaseService<IagUser> implements UserService{
    public Integer saveUser(IagUser user) throws DataBaseException {
        return baseDAO.save(user);
    }

    public IagUser addUser(IagUser user) throws BusinessException {
        if(user != null){
            if(isExistByEmail(user.getEmail())){
                throw new BusinessException(ExceptionEnum.USER_ADD_EXIST_EMAIL);
            }
            if(isExistByNickName(user.getNickname())){
                throw new BusinessException(ExceptionEnum.USER_ADD_EXIST_NICKNAME);
            }
            //初始化用户信息
            user = addInitUserInfo(user);
            Integer newId = saveUser(user);
            return (IagUser) baseDAO.queryById(com.iag.model.IagUser.class, newId);
        }
        return null;
    }

    //注册方法
    // TODO: 3/21/2017 register method 

    private IagUser addInitUserInfo(IagUser user){
        //1、初始化用户基本信息
        user.setIsDelete(ModelIsDelete.NOT_DELETE.value());
        Date nowDate = new Date();
        user.setLastModifyTime(nowDate);
        user.setRegisterTime(nowDate);
        //2、用户角色授权（默认授予普通会员角色）
        IagRole defaultRole = new IagRole();
        defaultRole.setId(3);
        user.getRoles().add(defaultRole);
        //3、加密用户密码
        user.setPassword(SecurityTools.toMd5(user.getPassword()));

        //4、初始化用户配置文件
        // TODO: 3/21/2017 暂时不写 
        return user;
    }

    public boolean isExistByNickName(String nickname) throws BusinessException {
        if(StringUtils.isNotBlank(nickname)){
            IagUser temp =  queryByFiled("nickname", nickname);
            if(temp != null){
                return true;
            }
        }
        return false;
    }

    public boolean isExistByEmail(String email) throws BusinessException {
        if(StringUtils.isNotBlank(email)){
            IagUser temp = queryByFiled("email", email);
            if(temp != null){
                return true;
            }
        }
        return false;
    }

    private IagUser queryByFiled(String filedName, String filedValue) throws DataBaseException{
        Conditions conditions = new Conditions();
        conditions.addCondition(filedName, filedValue, Conditions.Operator.EQUAL);
        return queryByConditions(conditions);
    }

    private IagUser queryByConditions(Conditions conditions) throws DataBaseException{
        List<IagUser> users = baseDAO.queryByConditions(com.iag.model.IagUser.class, conditions);
        if(users != null && users.size() > 0){
            return users.get(0);
        }
        return null;
    }
}
