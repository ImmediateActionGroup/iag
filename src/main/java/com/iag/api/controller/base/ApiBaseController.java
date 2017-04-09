package com.iag.api.controller.base;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.iag.api.model.ApiResult;
import com.iag.service.impl.ServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Created by beishan on 2017/3/19.
 */
@Controller
public class ApiBaseController {
    private final static String CONTENT_TYPE = "application/Json";
    @Autowired
    protected ServiceManager serviceManager;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;
    protected Gson gson;
    @Autowired
    protected ApiResult apiResult;

    @PostConstruct
    public void init(){
        gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }

    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response){
        this.request = request;
        this.response = response;
        this.session = request.getSession();
    }


    /**
     * render a String mesg
     * @param mesg
     */
    private void render(String mesg){
        try{
            response.setContentType(CONTENT_TYPE + ";charset=UTF-8");
            response.getWriter().print(mesg);
            response.getWriter().flush();
            response.getWriter().close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    /**
     * render a Object as json
     * @param json
     */
    private void renderObj(Object json){
        try{
            response.setContentType(CONTENT_TYPE + ";charset=UTF-8");
            response.getWriter().print(gson.toJson(json));
            response.getWriter().flush();
            response.getWriter().close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    /**
     * render a Object as json
     * @param json
     */
    private void renderObj(Object json, Type listType){
        try{
            //gson.toJson(json, listType);
            response.setContentType(CONTENT_TYPE + ";charset=UTF-8");
            response.getWriter().print(gson.toJson(json,listType));
            response.getWriter().flush();
            response.getWriter().close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 回传api 调用结果
     */
    public void renderResult(){
        this.renderObj(this.apiResult);
    }
    /*
    public EtUser getCurrentUser(){
        return (EtUser) session.getAttribute("currentUser");
    }
    */
    public void renderResult(String msg){
        this.renderResult(msg, null);
    }
    public void renderResult(String msg, Object data){
        this.apiResult.reset();
        this.apiResult.setApiResult(msg, data);
        this.renderResult();
    }
}
