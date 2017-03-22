package com.iag.service;

import com.iag.enums.UserBoardRole;
import com.iag.exception.ex.BusinessException;
import com.iag.model.IagUserBoard;

/**
 * Created by xueshan.wei on 2016/12/15.
 */
public interface UserBoardService {

    IagUserBoard addUserBoard(Integer uid, Integer bid, UserBoardRole role) throws BusinessException;


}
