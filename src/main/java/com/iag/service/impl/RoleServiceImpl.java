package com.iag.service.impl;

import com.iag.exception.ex.DataBaseException;
import com.iag.model.IagRole;
import com.iag.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * Created by beishan on 2017/3/8.
 */
@Service("roleService")
public class RoleServiceImpl extends BaseService<IagRole> implements RoleService {

    private Integer saveRole(IagRole role) throws DataBaseException {
        return baseDAO.save(role);
    }

    public IagRole queryRoleById(Integer roleId) throws DataBaseException {
        return (IagRole) baseDAO.queryById(com.iag.model.IagRole.class, roleId);
    }
}
