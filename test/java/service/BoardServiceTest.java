package service;

import base.BaseTest;
import com.iag.enums.UserBoardRole;
import com.iag.validate.ValidateBoard;
import org.junit.Test;

import javax.persistence.Table;

/**
 * Created by beishan on 2017/3/22.
 */
public class BoardServiceTest extends BaseTest {

    @Test
    public void add() throws Exception{
        ValidateBoard board = new ValidateBoard();
        board.setName("新版块");
        board.setDesc("这是版块描述");
        board.setUid(1);
        board.setRole(UserBoardRole.WEBMASTER.value());

        serviceManager.getBoardService().addBoard(board);
    }
}
