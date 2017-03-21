package com.iag.service;

import com.iag.exception.ex.BusinessException;
import com.iag.exception.ex.DataBaseException;
import com.iag.model.IagResource;

import java.util.List;

/**
 * Created by 李前程 on 2016/12/15.
 */
public interface ResourceService {

    IagResource addRes(String resName, String resValue) throws BusinessException;

    List<IagResource> queryAll() throws DataBaseException;
}
