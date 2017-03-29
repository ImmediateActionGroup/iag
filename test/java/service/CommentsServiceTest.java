package service;

import base.BaseTest;
import org.junit.Test;

/**
 * Created by beishan on 2017/3/25.
 */
public class CommentsServiceTest extends BaseTest {

    @Test
    public void test() throws Exception{
        serviceManager.getCommentsService().addComments(1, 1, 0, "这是回复的内容");
    }
}
