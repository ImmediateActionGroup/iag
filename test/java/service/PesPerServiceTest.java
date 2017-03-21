package service;

import base.BaseTest;
import com.iag.exception.enums.ExceptionEnum;
import com.iag.exception.ex.BusinessException;
import com.iag.exception.ex.DataBaseException;
import com.iag.model.IagPermission;
import com.iag.model.IagResPer;
import com.iag.model.IagResource;
import org.junit.Test;

import java.util.List;

/**
 * 资源权限测试类
 * Created by xueshan.wei on 3/21/2017.
 */
public class PesPerServiceTest extends BaseTest {

    /**
     * 用于初始化 资源权限
     */
    @Test
    public void init(){
        List<IagResource> resources = null;
        List<IagPermission> permissions = null;
        try {
            resources = serviceManager.getResourceService().queryAll();
            permissions = serviceManager.getPermissionService().queryAll();
        } catch (DataBaseException e) {
            e.printStackTrace();
        }

        if(resources != null && permissions != null){
            for(IagResource resource : resources){
                for(IagPermission permission : permissions){
                    try {
                        serviceManager.getResPerService().addResPer(resource, permission);
                    } catch (BusinessException e) {
                        ExceptionEnum ee = e.getEe();
                        System.out.println(ee.getCode() + "---" + ee.getMsg());
                    }
                }
            }
        }
    }

    @Test
    public void queryAll() throws Exception{
        List<IagResPer> resPers = serviceManager.getResPerService().queryAll();
        for(IagResPer resPer : resPers){
            System.out.println(resPer.getId() + "----" + resPer.getResPerValue());
        }
    }
}
