package com.iag.exception;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.iag.api.model.ApiResult;
import com.iag.exception.enums.ExceptionEnum;
import com.iag.exception.ex.ApiBusinessException;
import com.iag.exception.ex.CheckedException;
import com.iag.exception.ex.api.ApiParamException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 统一异常处理类，
 * 根据不同的需求返回视图或者是json
 * Created by xueshan.wei on 12/20/2016.
 */
@Component
public class GlobalExceptionResolver implements HandlerExceptionResolver{
    @Autowired
    private ApiResult apiResult;
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        //1、判断是哪种类型的异常信息
        //2、判断需要返回哪种类型的错误信息（视图/Json）
        if(e != null){
            if(e instanceof CheckedException){
                //返回json 异常信息
                if(e instanceof ApiBusinessException){
                    if(e instanceof ApiParamException){
                        //写入具体的错误信息
                        ApiParamException ape = (ApiParamException) e;
                        BindingResult bindingResult = (BindingResult) ape.getBindingResult();
                        Map<String, String> data = new HashMap<String, String>();
                        for(FieldError error : bindingResult.getFieldErrors()){
                            data.put(error.getField(), error.getDefaultMessage());
                        }
                        //写入异常信息
                        ExceptionEnum exceptionEnum = ape.getEe();
                        apiResult.setData(data);
                        apiResult.setCode(exceptionEnum.getCode());
                        apiResult.setMsg(exceptionEnum.getMsg());

                    }else{
                        ApiBusinessException abe = (ApiBusinessException) e;
                        ExceptionEnum exceptionEnum = abe.getEe();
                        apiResult.setCode(exceptionEnum.getCode());
                        apiResult.setMsg(exceptionEnum.getMsg());

                    }
                    renderJson(httpServletResponse, apiResult);
                }else{

                }
            }else if(e instanceof CheckedException){
                ModelAndView mv = new ModelAndView("/other/error");
                CheckedException ce = (CheckedException) e;
                ExceptionEnum exceptionEnum = ce.getEe();
                Map errorInfo = new HashMap();
                errorInfo.put("code", exceptionEnum.getCode());
                errorInfo.put("msg", exceptionEnum.getMsg());
                errorInfo.put("detail", ce.getLocalizedMessage());
                mv.addObject("errorInfo", errorInfo);

                return mv;
            }
        }
        ModelAndView mv = new ModelAndView("/other/error");
        Map errorInfo = new HashMap();
        //errorInfo.put("code", Integer.toString(ExceptionEnum.PAGE_NOT_FOUND.getCode()));
        //errorInfo.put("msg", ExceptionEnum.PAGE_NOT_FOUND.getMessage());
        //mv.addObject("errorInfo", errorInfo);
        e.printStackTrace();
        return mv;
    }

    private void renderJson(HttpServletResponse response, Object object){
        Gson gson = new GsonBuilder().create();
        response.setContentType("application/json;charset=UTF-8");
        try{
            PrintWriter printWriter = response.getWriter();
            printWriter.print(gson.toJson(object));
            printWriter.flush();
            printWriter.close();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
