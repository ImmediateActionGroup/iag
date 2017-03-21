package com.iag.service.impl;

import com.iag.exception.enums.ExceptionEnum;
import com.iag.exception.ex.BusinessException;
import com.iag.exception.ex.DataBaseException;
import com.iag.model.IagResPer;
import com.iag.model.IagRole;
import com.iag.service.ResPerService;
import com.iag.service.RoleService;
import com.iag.util.db.Conditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by beishan on 2017/3/8.
 */
@Service("roleService")
public class RoleServiceImpl extends BaseService<IagRole> implements RoleService {
    @Autowired
    private ResPerService resPerService;

    private Integer saveRole(IagRole role) throws DataBaseException {
        return baseDAO.save(role);
    }

    public IagRole addRole(String roleName, Integer[] resPerIds) throws BusinessException {
        if(isExistByName(roleName)){
            throw new BusinessException(ExceptionEnum.MODEL_EXIST);
        }
        IagResPer resPerTemp = null;
        IagRole newRole = new IagRole();
        newRole.setRoleName(roleName);
        for (int i = 0; i < resPerIds.length; i++) {
            resPerTemp = resPerService.queryById(resPerIds[i]);
            newRole.getResPers().add(resPerTemp);
        }
        Integer newId = baseDAO.save(newRole);
        return (IagRole) baseDAO.queryById(com.iag.model.IagRole.class, newId);
    }

    public IagRole queryRoleById(Integer roleId) throws DataBaseException {
        return (IagRole) baseDAO.queryById(com.iag.model.IagRole.class, roleId);
    }

    private boolean isExistByName(String roleName) throws DataBaseException{
        Conditions conditions = new Conditions();
        conditions.addCondition("roleName", roleName, Conditions.Operator.EQUAL);

        List<IagRole> list = baseDAO.queryByConditions(com.iag.model.IagRole.class, conditions);
        if(list != null && list.size() > 0){
            return true;
        }
        return false;
    }

    public List<IagRole> queryAll() throws DataBaseException {
        return baseDAO.queryAll(com.iag.model.IagRole.class);
    }
}
