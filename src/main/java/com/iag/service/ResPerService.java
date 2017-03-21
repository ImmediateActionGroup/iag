package com.iag.service;

import com.iag.exception.ex.BusinessException;
import com.iag.exception.ex.DataBaseException;
import com.iag.model.IagPermission;
import com.iag.model.IagResPer;
import com.iag.model.IagResource;

import java.util.List;

/**
 * Created by xueshan.wei on 3/21/2017.
 */
public interface ResPerService {

    IagResPer addResPer(IagResource resource, IagPermission permission) throws BusinessException;

    List<IagResPer> queryAll() throws DataBaseException;

    IagResPer queryById(Integer id) throws DataBaseException;
}
