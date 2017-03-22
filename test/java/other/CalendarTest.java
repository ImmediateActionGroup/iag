package other;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by xueshan.wei on 3/22/2017.
 */
public class CalendarTest {

    @Test
    public void test() throws Exception{
        Date nowDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowDate);
        long t1 = calendar.getTimeInMillis();
        System.out.println(t1);
        Integer time = 60;
        long t2 = t1 + time * 60;
        System.out.println(t2);
    }
}
