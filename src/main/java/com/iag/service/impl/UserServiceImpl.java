package com.iag.service.impl;

import com.iag.enums.ModelIsDelete;
import com.iag.exception.enums.ExceptionEnum;
import com.iag.exception.ex.BusinessException;
import com.iag.exception.ex.DataBaseException;
import com.iag.model.IagRole;
import com.iag.model.IagUser;
import com.iag.service.RoleService;
import com.iag.service.UserService;
import com.iag.util.SecurityTools;
import com.iag.util.db.Conditions;
import com.iag.validate.ValidateUser;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by beishan on 2017/3/8.
 */
@Service("userService")
public class UserServiceImpl extends BaseService<IagUser> implements UserService{
    /**
     * 自动生成用户昵称的前缀
     */
    private final String USER_NICKNAME_PREFIX = "iag_";

    /**
     * 设置自动生成昵称次数超时次数
     */
    private final int GENERATE_NICKNAME_TIMEOUT = 10;

    @Autowired
    private RoleService roleService;

    public IagUser login(String account, String password) throws BusinessException {
        //
        IagUser user = isExistByEmail(account);
        if(user != null){
            if(!user.getPassword().equals(SecurityTools.toMd5(password))){
                throw new BusinessException(ExceptionEnum.USER_LOGIN_PWD_ERROR);
            }
            //记录用户登录时间
            user.setLastLoginTime(new Date());
            baseDAO.update(user);
            return user;
        }else{
            throw new BusinessException(ExceptionEnum.USER_NOT_EXIST);
        }
    }

    public List<IagUser> queryAll() throws DataBaseException {
        return baseDAO.queryAll(com.iag.model.IagUser.class);
    }

    public IagUser register(ValidateUser user) throws BusinessException {
        IagUser newUser = new IagUser();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        //初始化用户角色
        newUser = setUserRole(newUser);
        return addUser(newUser);
    }

    public IagUser addUser(ValidateUser user) throws BusinessException {
        IagUser newUser = new IagUser();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        //初始化用户角色
        newUser = setUserRole(newUser, user.getRoleValue());
        return addUser(newUser);
    }

    /**
     * 保存用户实体
     * @param user
     * @return 新建成功的用户id
     * @throws DataBaseException
     */
    private Integer saveUser(IagUser user) throws DataBaseException {
        return baseDAO.save(user);
    }

    public IagUser addUser(IagUser user) throws BusinessException {
        if(user != null){
            if(isExistByEmail(user.getEmail()) != null){
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

    /**
     * 自动生成昵称，默认尝试10次
     * @return
     * @throws BusinessException
     */
    private String generateNickName() throws BusinessException{
        String nickname = null;
        boolean isExist = true;
        int timeout = 1;
        while (isExist && timeout < GENERATE_NICKNAME_TIMEOUT){
            nickname = USER_NICKNAME_PREFIX +  UUID.randomUUID().toString().substring(0, 8);
            try {
                if(!isExistByNickName(nickname)){
                    isExist = false;
                }
            } catch (DataBaseException e) {
                e.printStackTrace();
                throw new BusinessException(ExceptionEnum.DB_QUERY_ERROR);
            }
            timeout ++;
        }

        // TODO: 2017/3/21 time out is should to do something
        //或许应该抛出一个异常
        return nickname;
    }


    private IagUser addInitUserInfo(IagUser user)throws BusinessException{
        //1、初始化用户基本信息
        user.setIsDelete(ModelIsDelete.NOT_DELETE.value());
        Date nowDate = new Date();
        user.setLastModifyTime(nowDate);
        user.setRegisterTime(nowDate);

        //2、加密用户密码
        user.setPassword(SecurityTools.toMd5(user.getPassword()));

        //3、初始化用户配置文件
        // TODO: 3/21/2017 暂时不写

        //4、设置用户默认昵称
        user.setNickname(generateNickName());

        return user;
    }

    private IagUser setUserRole(IagUser user, Integer roleId) throws BusinessException{
        //查询要设置的角色是否存在
        IagRole role = roleService.queryRoleById(roleId);
        if(role != null){
            user.getRoles().add(role);
            return user;
        }else{
            //角色不存在抛出异常
            throw new BusinessException(ExceptionEnum.ROLE_NOT_EXIST);
        }
    }

    private IagUser setUserRole(IagUser user) throws DataBaseException{
        //用户角色授权（默认授予普通会员角色）
        IagRole defaultRole = new IagRole();
        defaultRole.setId(3);
        user.getRoles().add(defaultRole);
        return user;
    }

    public boolean isExistByNickName(String nickname) throws DataBaseException {
        if(StringUtils.isNotBlank(nickname)){
            IagUser temp =  queryByFiled("nickname", nickname);
            if(temp != null){
                return true;
            }
        }
        return false;
    }

    public IagUser isExistByEmail(String email) throws DataBaseException {
        if(StringUtils.isNotBlank(email)){
            IagUser temp = queryByFiled("email", email);
            if(temp != null){
                return temp;
            }
        }
        return null;
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

    public IagUser queryById(Integer uid) throws DataBaseException {
        return (IagUser) baseDAO.queryById(com.iag.model.IagUser.class, uid);
    }
}
