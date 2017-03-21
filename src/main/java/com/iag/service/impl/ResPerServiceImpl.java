package com.iag.service.impl;

import com.iag.exception.enums.ExceptionEnum;
import com.iag.exception.ex.BusinessException;
import com.iag.exception.ex.DataBaseException;
import com.iag.model.IagPermission;
import com.iag.model.IagResPer;
import com.iag.model.IagResource;
import com.iag.service.ResPerService;
import com.iag.util.db.Conditions;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xueshan.wei on 3/21/2017.
 */
@Service("resPerService")
public class ResPerServiceImpl extends BaseService<IagResPer> implements ResPerService {
    public IagResPer addResPer(IagResource resource, IagPermission permission) throws BusinessException {
        if(!isExistByResAndPer(resource, permission)){
            IagResPer resPer = new IagResPer();
            resPer.setResource(resource);
            resPer.setPermission(permission);
            resPer.setResPerValue(resource.getResourceValue() + ":" + permission.getPermissionName());
            Integer newId = baseDAO.save(resPer);
            return (IagResPer) baseDAO.queryById(com.iag.model.IagResPer.class, newId);
        }else{
            throw new BusinessException(ExceptionEnum.MODEL_EXIST);
        }
    }

    public List<IagResPer> queryAll() throws DataBaseException {
        return baseDAO.queryAll(com.iag.model.IagResPer.class);
    }

    private boolean isExistByResAndPer(IagResource resource, IagPermission permission) throws DataBaseException{
        Conditions conditions = new Conditions();
        conditions.addCondition("resource.resourceName", resource.getResourceName(), Conditions.Operator.EQUAL);
        conditions.addCondition("permission.permissionName", permission.getPermissionName(), Conditions.Operator.EQUAL);

        List<IagResPer> list = baseDAO.queryByConditions(com.iag.model.IagResPer.class, conditions);
        if(list != null && list.size() > 0){
            return true;
        }
        return false;
    }
}
