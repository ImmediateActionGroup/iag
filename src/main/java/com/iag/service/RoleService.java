package com.iag.service;

import com.iag.exception.ex.DataBaseException;
import com.iag.model.IagRole;

/**
 * Created by 李前程 on 2016/12/15.
 */
public interface RoleService {

    //IagRole addRole()

    IagRole queryRoleById(Integer roleId) throws DataBaseException;
}
