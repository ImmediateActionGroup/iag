package com.iag.service;

import com.iag.exception.ex.BusinessException;
import com.iag.exception.ex.DataBaseException;
import com.iag.model.IagRole;

import java.util.List;

/**
 * Created by 李前程 on 2016/12/15.
 */
public interface RoleService {

    IagRole addRole(String roleName, Integer [] resPerIds) throws BusinessException;

    IagRole queryRoleById(Integer roleId) throws DataBaseException;

    List<IagRole> queryAll() throws DataBaseException;
}
