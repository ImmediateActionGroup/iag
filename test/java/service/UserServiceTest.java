package service;

import base.BaseTest;
import com.iag.model.IagRole;
import com.iag.model.IagUser;
import com.iag.validate.ValidateUser;
import org.junit.Test;

import java.util.List;

/**
 * Created by xueshan.wei on 3/21/2017.
 */
public class UserServiceTest extends BaseTest{
    /**
     * 后台添加用户
     * @throws Exception
     */
    @Test
    public void addUser() throws Exception{
        ValidateUser user = new ValidateUser();
        user.setEmail("3122222@test.com");
        user.setPassword("123456");
        user.setRoleValue(1);

        IagUser newUser = serviceManager.getUserService().addUser(user);
        System.out.println(newUser.toString());

    }

    @Test
    public void register() throws Exception{
        ValidateUser user = new ValidateUser();
        user.setEmail("reg22222@test.com");
        user.setPassword("123456");

        IagUser newUser = serviceManager.getUserService().register(user);
        System.out.println(newUser.toString());
    }

    @Test
    public void queryAll() throws Exception{
        List<IagUser> users = serviceManager.getUserService().queryAll();
        // TODO: 2017/3/21 no session to do this operation 
        for(IagUser user : users){
            System.out.println(user.toString());
            for(IagRole role : user.getRoles()){
                System.out.println(role.getRoleName());
            }
            System.out.println("+++++++++++++++++++++++++++++++++++");
        }
    }
}
