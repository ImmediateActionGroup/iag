package com.iag.service;

import com.iag.exception.ex.BusinessException;
import com.iag.exception.ex.DataBaseException;
import com.iag.model.IagDarkroom;

import java.util.List;

/**
 * Created by beishan on 2017/3/21.
 */
public interface DarkroomService {

    IagDarkroom addDarkroom(Integer uid, Integer days, String reason) throws BusinessException;

    void removeDarkroom(Integer drid, String abortReason) throws BusinessException;

    /**
     *
     * @param drid
     * @return
     * @throws DataBaseException
     */
    IagDarkroom queryById(Integer drid) throws DataBaseException;

    List<IagDarkroom> queryAll() throws DataBaseException;
}
