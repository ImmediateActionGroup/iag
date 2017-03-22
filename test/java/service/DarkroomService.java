package service;

import base.BaseTest;
import org.junit.Test;

/**
 * Created by xueshan.wei on 3/22/2017.
 */
public class DarkroomService extends BaseTest {

    @Test
    public void testAddDarkRoom() throws Exception{
        serviceManager.getDarkroomService().addDarkroom(1, 5, "再次关进小黑屋");
    }

    @Test
    public void testRemoveDarkroom() throws Exception{
        serviceManager.getDarkroomService().removeDarkroom(1, "放了你吧");
    }

    @Test
    public void testSynoTimeup() throws Exception{
        serviceManager.getDarkroomService().synoCheckDrStatus();
    }
}
