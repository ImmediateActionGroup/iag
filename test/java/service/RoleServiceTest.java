package service;

import base.BaseTest;
import com.iag.model.IagResPer;
import com.iag.model.IagRole;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xueshan.wei on 3/21/2017.
 */
public class RoleServiceTest extends BaseTest {

    @Test
    public void addRole() throws Exception{

        List<Integer> rpids = new ArrayList<Integer>();
        for(IagResPer resPer : serviceManager.getResPerService().queryAll()){
            rpids.add(resPer.getId());
        }
        Integer [] resPerIds = new Integer[rpids.size()];
        rpids.toArray(resPerIds);

        serviceManager.getRoleService().addRole("管理员", resPerIds);
    }



    @Test
    public void queryAll() throws Exception{
        List<IagRole> roles = serviceManager.getRoleService().queryAll();
        for(IagRole role : roles){
            System.out.println("角色：" + role.getRoleName() + "(" + role.getResPers().size() + ")");
            for(IagResPer resPer : role.getResPers()){
                System.out.println(resPer.getId() + "----" + resPer.getResPerValue());
            }
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
    }
}
