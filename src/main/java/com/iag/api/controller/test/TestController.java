package com.iag.api.controller.test;

import com.iag.annotation.ControllerLog;
import com.iag.api.controller.base.ApiBaseController;
import com.iag.enums.log.SystemLog;
import com.iag.exception.ex.ApiBusinessException;
import com.iag.exception.ex.CheckedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by beishan on 2017/3/19.
 */
@Controller(value = "apiTestController")
@RequestMapping(value = "/test")
public class TestController extends ApiBaseController {

    @RequestMapping(value = "/api", method = RequestMethod.GET)
    @ControllerLog(log = SystemLog.DEFAULT)
    public void test1() throws ApiBusinessException{

        this.apiResult.reset();
        this.apiResult.setMsg("测试api 成功");
        this.renderResult();
    }
}
