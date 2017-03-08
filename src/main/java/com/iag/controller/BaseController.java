package com.iag.controller;

import com.google.gson.Gson;
import com.iag.api.model.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * BaseController 类，
 * 封装了一些JSon回写的方法，以及基本的Response 和 request 对象
 * Created by beishan on 2017/3/8.
 */
@Controller("baseController")
public class BaseController {
    private final String CONTENT_TYPE = "application/json; charset=utf-8";
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;

    private Gson gson;

    @Autowired
    protected ApiResult apiResult;

    public BaseController(){
        gson = new Gson();
    }

    /**
     * 初始化 request、response、session
     * @param request
     * @param response
     */
    @ModelAttribute
    public void setRespAndReq(HttpServletRequest request, HttpServletResponse response){
        this.request = request;
        this.response = response;
        this.session = request.getSession();
    }

    /**
     * 回写 API 返回结果
     */
    public void renderApiResult(){
        response.setContentType(this.CONTENT_TYPE);
        try {
            PrintWriter print = response.getWriter();
            print.print(this.gson.toJson(this.apiResult));
            print.flush();
            print.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
