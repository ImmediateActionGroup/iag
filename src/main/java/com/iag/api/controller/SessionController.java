package com.iag.api.controller;

import com.iag.annotation.ControllerLog;
import com.iag.api.controller.base.ApiBaseController;
import com.iag.api.model.ApiResult;
import com.iag.exception.enums.ExceptionEnum;
import com.iag.exception.ex.ApiBusinessException;
import com.iag.exception.ex.BusinessException;
import com.iag.model.IagUser;
import com.iag.validate.ValidateLogin;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by beishan on 2017/3/19.
 */
@Api(value = "session", description = "用户session相关")
@Controller(value = "apiSessionController")
@RequestMapping(value = "/api")
public class SessionController extends ApiBaseController {

    /**
     * 用户登录类
     * @param login 用户数据接收验证类
     * @throws ApiBusinessException
     */
    @RequestMapping(value = "/session", method = RequestMethod.POST)
    @ApiOperation(value = "用户登录", notes = "用于用户登录",
            response = ApiResult.class, httpMethod = "POST")
    @ControllerLog
    public void login(@Valid @RequestBody ValidateLogin login, BindingResult bindingResult) throws ApiBusinessException{
        if(bindingResult.hasErrors()){
            throw new ApiBusinessException(ExceptionEnum.PARAM_ERROR, bindingResult);
        }
        //登录逻辑
        try {
            IagUser currentUser = serviceManager.getUserService().login(login.getAccount(), login.getPassword());
            session.setAttribute("currentUser", currentUser);
            this.apiResult.reset();
            this.apiResult.setApiResult("登录成功", currentUser);
            this.renderResult();
        } catch (BusinessException e) {
            e.printStackTrace();
            throw new ApiBusinessException(ExceptionEnum.USER_LOGIN_FAIL);
        }
    }

    /**
     * 用户注销登录
     * @throws ApiBusinessException
     */
    @RequestMapping(value = "/session", method = RequestMethod.DELETE)
    @ApiOperation(value = "用户注销登录", notes = "用于用户注销登录",
            response = ApiResult.class, httpMethod = "DELETE")
    @ControllerLog
    public void logout() throws ApiBusinessException{
        //退出登录逻辑
    }

    /**
     * 得到当前登录用户的用户信息
     * @throws ApiBusinessException
     */
    @RequestMapping(value = "/session", method = RequestMethod.GET)
    @ApiOperation(value = "得到当前登录用户信息", notes = "用于得到当前登录的用户的用户信息",
            response = ApiResult.class, httpMethod = "GET")
    @ControllerLog
    public void getCurrentLoginUser() throws ApiBusinessException{
        //得到当前登录用户信息的逻辑

    }
}
