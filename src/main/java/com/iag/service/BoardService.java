package com.iag.service;

import com.iag.exception.ex.BusinessException;
import com.iag.exception.ex.DataBaseException;
import com.iag.model.IagBoard;
import com.iag.validate.ValidateBoard;

/**
 * Created by xueshan.wei on 2016/12/15.
 */
public interface BoardService {

    IagBoard addBoard(ValidateBoard board) throws BusinessException;

    IagBoard queryById(Integer bid) throws DataBaseException;
}
