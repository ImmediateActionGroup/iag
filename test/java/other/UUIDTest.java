package other;

import org.junit.Test;

import java.util.UUID;

/**
 * Created by beishan on 2017/3/21.
 */
public class UUIDTest {

    @Test
    public void test(){
        String uuid = null;
        String nid = null;
        for (int i = 0; i < 10; i++) {
            uuid = UUID.randomUUID().toString();
            nid = uuid.substring(0, 8);
            System.out.println(uuid);
            System.out.println(nid);
        }
    }
}
