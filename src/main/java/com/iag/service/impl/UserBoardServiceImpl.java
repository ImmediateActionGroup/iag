package com.iag.service.impl;

import com.iag.enums.UserBoardRole;
import com.iag.exception.enums.ExceptionEnum;
import com.iag.exception.ex.BusinessException;
import com.iag.exception.ex.DataBaseException;
import com.iag.model.IagBoard;
import com.iag.model.IagUser;
import com.iag.model.IagUserBoard;
import com.iag.service.UserBoardService;
import com.iag.util.db.Conditions;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by beishan on 2017/3/8.
 */
@Service("userBoardService")
public class UserBoardServiceImpl extends BaseService<IagUserBoard> implements UserBoardService {

    public IagUserBoard addUserBoard(Integer uid, Integer bid, UserBoardRole role) throws BusinessException {
        IagUserBoard ub = queryByUidAndBid(uid, bid);
        if(ub == null){
            IagUser user = new IagUser();
            user.setId(uid);
            IagBoard board = new IagBoard();
            board.setId(bid);
            ub = new IagUserBoard();
            ub.setUser(user);
            ub.setBoard(board);
            ub.setRoleValue(role.value());

            Integer newId = baseDAO.save(ub);
            return (IagUserBoard) baseDAO.queryById(com.iag.model.IagUserBoard.class, newId);
        }else{
            throw new BusinessException(ExceptionEnum.MODEL_EXIST);
        }
    }

    private IagUserBoard queryByUidAndBid(Integer uid, Integer bid) throws DataBaseException{
        Conditions conditions = new Conditions();
        conditions.addCondition("user.id", uid, Conditions.Operator.EQUAL);
        conditions.addCondition("board.id", bid, Conditions.Operator.EQUAL);
        List<IagUserBoard> list = baseDAO.queryByConditions(com.iag.model.IagUserBoard.class, conditions);
        if(list != null && list.size() > 0){
            return list.get(0);
        }
        return null;
    }
}
