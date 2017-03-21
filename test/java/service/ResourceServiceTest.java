package service;

import base.BaseTest;
import com.iag.exception.enums.ExceptionEnum;
import com.iag.exception.ex.BusinessException;
import com.iag.model.IagResource;
import org.junit.Test;

import java.util.List;

/**
 * Created by xueshan.wei on 3/21/2017.
 */
public class ResourceServiceTest extends BaseTest {

    @Test
    public void addResource() throws Exception{
        serviceManager.getResourceService().addRes("用户", "user");
    }

    @Test
    public void initResource() throws Exception{
        String [] resNames = {"用户", "帖子", "回复", "板块", "私信", "角色", "系统配置"};
        String [] resValues = {"user", "posts", "comments", "board", "message", "role", "sysconfig"};
        for (int i = 0; i < resNames.length; i++) {
            try{
                serviceManager.getResourceService().addRes(resNames[i], resValues[i]);
            }catch (BusinessException e){
                ExceptionEnum ee = e.getEe();
                System.out.println(ee.getCode() + "---" + ee.getMsg());
            }
        }
    }

    @Test
    public void queryAll() throws Exception{
        List<IagResource> resources = serviceManager.getResourceService().queryAll();
        if(resources != null && resources.size() > 0){
            for(IagResource r : resources){
                System.out.println(r.getId() + "----" + r.getResourceName() + "----" + r.getResourceValue());
            }
        }else{
            System.out.println("资源集合为空");
        }
    }
}
