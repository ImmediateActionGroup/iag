package com.iag.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xueshan.wei on 12/13/2016.
 */
@Controller
@RequestMapping
public class TestController {
    @RequestMapping(value = "/test")
    public String test(){
        return "test";
    }
}
