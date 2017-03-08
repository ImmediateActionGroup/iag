package com.iag.service.impl;

import com.iag.dao.impl.BaseDAO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by beishan on 2017/3/8.
 */
public class BaseService<T> {
    @Autowired
    protected BaseDAO<T> baseDAO;

}
