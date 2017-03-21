package com.iag.service;

import com.iag.exception.ex.BusinessException;
import com.iag.exception.ex.DataBaseException;
import com.iag.model.IagUser;
import com.iag.validate.ValidateUser;

import java.util.List;

/**
 * Created by 李前程 on 2016/12/15.
 */
public interface UserService {

    List<IagUser> queryAll() throws DataBaseException;
    /**
     * 增加一个用户
     * @param user
     * @return 返回新增的用户实体
     * @throws BusinessException
     */
    IagUser addUser(IagUser user) throws BusinessException;

    /**
     * 用户注册
     * @param user
     * @return
     * @throws BusinessException
     */
    IagUser register(ValidateUser user) throws BusinessException;


    /**
     * 后台添加用户
     * @param user
     * @return
     * @throws BusinessException
     */
    IagUser addUser(ValidateUser user) throws BusinessException;

    /**
     * 根据用户昵称查询用户是否存在
     * @param nickname
     * @return
     * @throws BusinessException
     */
    boolean isExistByNickName(String nickname) throws DataBaseException;

    /**
     * 根据用户邮箱查询用户是否存在
     * @param email
     * @return
     * @throws BusinessException
     */
    boolean isExistByEmail(String email) throws DataBaseException;

    IagUser queryById(Integer uid) throws DataBaseException;
}
