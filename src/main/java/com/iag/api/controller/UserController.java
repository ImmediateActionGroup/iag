package com.iag.api.controller;

import com.iag.api.controller.base.ApiBaseController;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户相关API
 * Created by beishan on 2017/3/19.
 */
@Api(value = "user", description = "用户相关")
@RequestMapping(value = "/api")
@Controller(value = "apiUserController")
public class UserController extends ApiBaseController {

}
