package com.iag.service.impl;

import com.iag.exception.enums.ExceptionEnum;
import com.iag.exception.ex.BusinessException;
import com.iag.exception.ex.DataBaseException;
import com.iag.model.IagResource;
import com.iag.service.ResourceService;
import com.iag.util.db.Conditions;
import org.springframework.stereotype.Service;

import javax.enterprise.deploy.model.exceptions.DDBeanCreateException;
import java.util.List;

/**
 * Created by beishan on 2017/3/8.
 */
@Service("resourceService")
public class ResourceServiceImpl extends BaseService<IagResource> implements ResourceService {

    private Integer saveRes(IagResource resource) throws DataBaseException {
        return baseDAO.save(resource);
    }

    public IagResource addRes(String resName, String resValue) throws BusinessException {
        //资源名称不能重复
        if(!isExistByNameAndValue(resName, resValue)){
            IagResource newRes = new IagResource();
            newRes.setResourceName(resName);
            newRes.setResourceValue(resValue);
            Integer newResId = saveRes(newRes);
            return (IagResource) baseDAO.queryById(com.iag.model.IagResource.class, newResId);
        }else {
            throw new BusinessException(ExceptionEnum.MODEL_EXIST);
        }
    }

    public List<IagResource> queryAll() throws DataBaseException {
        return baseDAO.queryAll(com.iag.model.IagResource.class);
    }

    private boolean isExistByNameAndValue(String resName, String resValue) throws DataBaseException{
        Conditions conditions = new Conditions();
        conditions.addCondition("resourceName", resName, Conditions.Operator.EQUAL);
        conditions.addCondition("resourceValue", resValue, Conditions.Operator.EQUAL);
        IagResource temp = queryByConditions(conditions);
        if(temp != null){
            return true;
        }
        return false;
    }

    private boolean isExistByFiled(String filedName, String filedValue) throws DataBaseException{
        Conditions conditions = new Conditions();
        conditions.addCondition(filedName, filedValue, Conditions.Operator.EQUAL);
        IagResource temp = queryByConditions(conditions);
        if(temp != null){
            return true;
        }
        return false;
    }

    private IagResource queryByConditions(Conditions conditions) throws DataBaseException{
        List<IagResource> ress = baseDAO.queryByConditions(com.iag.model.IagResource.class, conditions);
        if(ress != null && ress.size() > 0){
            return ress.get(0);
        }
        return null;
    }
}
