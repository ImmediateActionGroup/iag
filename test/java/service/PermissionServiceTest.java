package service;

import base.BaseTest;
import com.iag.enums.permission.PermissionEnum;
import com.iag.exception.enums.ExceptionEnum;
import com.iag.exception.ex.BusinessException;
import com.iag.model.IagPermission;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xueshan.wei on 3/21/2017.
 */
public class PermissionServiceTest extends BaseTest {

    @Test
    public void savePer() throws Exception{
        serviceManager.getPermissionService().addPermission(PermissionEnum.ADD.value());
    }

    @Test
    public void initPer(){
        List<String> pers = new ArrayList<String>();
        pers.add(PermissionEnum.ADD.value());
        pers.add(PermissionEnum.DELETE.value());
        pers.add(PermissionEnum.QUERY.value());
        pers.add(PermissionEnum.UPDATE.value());
        for(String per : pers){
            try {
                serviceManager.getPermissionService().addPermission(per);
            } catch (BusinessException e) {
                ExceptionEnum ee = e.getEe();
                System.out.println(ee.getCode() + "---" + ee.getMsg());
            }
        }
    }

    @Test
    public void queryAll() throws Exception{
        List<IagPermission> permissions = serviceManager.getPermissionService().queryAll();
        if(permissions != null && permissions.size() > 0){
            for(IagPermission p : permissions){
                System.out.println(p.getId() + "----" + p.getPermissionName());
            }
        }else{
            System.out.println("权限集合为空");
        }
    }
}
