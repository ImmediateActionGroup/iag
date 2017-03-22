package com.iag.service;

import com.iag.exception.ex.BusinessException;
import com.iag.exception.ex.DataBaseException;
import com.iag.model.IagDarkroom;

import java.util.List;

/**
 * Created by beishan on 2017/3/21.
 */
public interface DarkroomService {
    /**
     * 检查小黑屋，看是否有应该刑满释放的人员，如果有就释放
     *
     * @throws DataBaseException
     */
    void synoCheckDrStatus() throws DataBaseException;

    /**
     * 把某人关进小黑屋
     * 如果要关押进小黑屋的人还有生效的记录的话，就先废除先前的记录然后使新记录生效
     * @param uid 要关押进小黑屋的人的id
     * @param minutes 关押的天数
     * @param reason
     * @return
     * @throws BusinessException
     */
    IagDarkroom addDarkroom(Integer uid, Integer minutes, String reason) throws BusinessException;

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
