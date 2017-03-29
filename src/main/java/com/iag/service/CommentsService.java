package com.iag.service;

import com.iag.exception.ex.BusinessException;
import com.iag.exception.ex.DataBaseException;
import com.iag.model.IagComments;
import com.iag.validate.ValidateComments;

import java.util.List;

/**
 * Created by xueshan.wei on 2016/12/15.
 */
public interface CommentsService {

    IagComments addComments(Integer uid, Integer pid, Integer parentId, String content) throws BusinessException;

    List<IagComments> queryAll() throws DataBaseException;

    IagComments queryById(Integer cid) throws DataBaseException;
}
