package com.iag.service.impl;

import com.iag.enums.ModelIsDelete;
import com.iag.enums.UserBoardRole;
import com.iag.exception.enums.ExceptionEnum;
import com.iag.exception.ex.BusinessException;
import com.iag.exception.ex.DataBaseException;
import com.iag.model.IagBoard;
import com.iag.service.BoardService;
import com.iag.service.UserBoardService;
import com.iag.util.db.Conditions;
import com.iag.validate.ValidateBoard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by beishan on 2017/3/8.
 */
@Service("boardService")
public class BoardServiceImpl extends BaseService<IagBoard> implements BoardService {
    @Autowired
    private UserBoardService userBoardService;

    public IagBoard addBoard(ValidateBoard board) throws BusinessException {
        IagBoard boardTemp = queryByName(board.getName());
        if(boardTemp != null){
            throw new BusinessException(ExceptionEnum.MODEL_EXIST);
        }else {
            boardTemp = new IagBoard();
            boardTemp.setIsDelete(ModelIsDelete.NOT_DELETE.value());
            boardTemp.setIcon(board.getIcon());
            boardTemp.setDescription(board.getDesc());
            boardTemp.setBoardName(board.getName());

            Integer newId = baseDAO.save(boardTemp);
            boardTemp = (IagBoard) baseDAO.queryById(com.iag.model.IagBoard.class, newId);

            userBoardService.addUserBoard(board.getUid(), boardTemp.getId(), UserBoardRole.getUBR(board.getRole()));

            return boardTemp;
        }
    }

    public IagBoard queryById(Integer bid) throws DataBaseException {
        return (IagBoard) baseDAO.queryById(com.iag.model.IagBoard.class, bid);
    }

    private IagBoard queryByName(String name) throws DataBaseException{
        Conditions conditions = new Conditions();
        conditions.addCondition("boardName", name, Conditions.Operator.EQUAL);

        List<IagBoard> list = baseDAO.queryByConditions(com.iag.model.IagBoard.class, conditions);
        if(list != null && list.size() > 0){
            return list.get(0);
        }
        return null;
    }
}
