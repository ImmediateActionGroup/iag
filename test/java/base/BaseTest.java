package base;

/**
 * Created by beishan on 2016/11/12.
 */

import com.iag.service.impl.ServiceManager;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext.xml", "classpath:spring/springmvc-servlet.xml"})
public class BaseTest {
    @Autowired
    protected ServiceManager serviceManager;
}
