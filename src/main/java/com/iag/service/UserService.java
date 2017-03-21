package com.iag.service;

import com.iag.exception.ex.BusinessException;
import com.iag.exception.ex.DataBaseException;
import com.iag.model.IagUser;

/**
 * Created by 李前程 on 2016/12/15.
 */
public interface UserService {

    /**
     * 保存用户实体
     * @param user
     * @return 新建成功的用户id
     * @throws DataBaseException
     */
    Integer saveUser(IagUser user) throws DataBaseException;

    /**
     * 增加一个用户
     * @param user
     * @return 返回新增的用户实体
     * @throws BusinessException
     */
    IagUser addUser(IagUser user) throws BusinessException;

    /**
     * 根据用户昵称查询用户是否存在
     * @param nickname
     * @return
     * @throws BusinessException
     */
    boolean isExistByNickName(String nickname) throws BusinessException;

    /**
     * 根据用户邮箱查询用户是否存在
     * @param email
     * @return
     * @throws BusinessException
     */
    boolean isExistByEmail(String email) throws BusinessException;
}
