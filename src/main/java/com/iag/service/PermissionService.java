package com.iag.service;

import com.iag.exception.ex.BusinessException;
import com.iag.exception.ex.DataBaseException;
import com.iag.model.IagPermission;

import java.util.List;

/**
 * Created by 李前程 on 2016/12/15.
 */
public interface PermissionService {

    IagPermission addPermission(String per) throws BusinessException;

    List<IagPermission> queryAll() throws DataBaseException;
}
