package com.iag.service.impl;

import com.iag.exception.enums.ExceptionEnum;
import com.iag.exception.ex.BusinessException;
import com.iag.exception.ex.DataBaseException;
import com.iag.model.IagPermission;
import com.iag.service.PermissionService;
import com.iag.util.db.Conditions;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by beishan on 2017/3/8.
 */
@Service("permissionService")
public class PermissionServiceImpl extends BaseService<IagPermission> implements PermissionService {
    private Integer savePermission(IagPermission permission) throws DataBaseException{
        return baseDAO.save(permission);
    }
    public IagPermission addPermission(String per) throws BusinessException {
        if(!isExistByPer(per)){
            IagPermission permission = new IagPermission();
            permission.setPermissionName(per);
            Integer newId = savePermission(permission);
            return (IagPermission) baseDAO.queryById(com.iag.model.IagPermission.class, newId);
        }else{
            throw new BusinessException(ExceptionEnum.MODEL_EXIST);
        }
    }

    public List<IagPermission> queryAll() throws DataBaseException {
        return baseDAO.queryAll(com.iag.model.IagPermission.class);
    }

    private boolean isExistByPer(String per) throws DataBaseException{
        Conditions conditions = new Conditions();
        conditions.addCondition("permissionName", per, Conditions.Operator.EQUAL);
        IagPermission temp = queryByConditions(conditions);
        if(temp != null){
            return true;
        }
        return false;
    }
    private IagPermission queryByConditions(Conditions conditions) throws DataBaseException{
        List<IagPermission> list = baseDAO.queryByConditions(com.iag.model.IagPermission.class, conditions);
        if(list != null && list.size() > 0){
            return list.get(0);
        }
        return null;
    }
}
