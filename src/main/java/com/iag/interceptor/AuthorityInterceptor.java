package com.iag.interceptor;

import com.iag.annotation.AuthorityCheck;
import com.iag.enums.user.UserAttrbute;
import com.iag.exception.enums.ExceptionEnum;
import com.iag.exception.ex.ApiBusinessException;
import com.iag.model.IagUser;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by beishan on 2017/4/8.
 */
public class AuthorityInterceptor extends HandlerInterceptorAdapter {
    private List<String> unchekUrls;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        String url = requestURI.substring(contextPath.length());

        //过滤路径
        if(unchekUrls != null && unchekUrls.contains(url)){
            return true;
        }

        //处理Permission Annotation，实现方法级权限控制
        HandlerMethod method = null;
        if (handler instanceof HandlerMethod){
            method = (HandlerMethod)handler;
        }else {
            return true;
        }

        AuthorityCheck authorityCheck = method.getMethodAnnotation(AuthorityCheck.class);
        //为空表示不需要验证
        if(authorityCheck == null){
            return true;
        }

        //登录验证
        HttpSession session = request.getSession();
        IagUser user = (IagUser) session.getAttribute(UserAttrbute.CURRENT_USER.value());
        if(user == null){
            //用户未登录
            if(url.indexOf("/api/") != -1){
                //返回api 异常
                throw new ApiBusinessException(ExceptionEnum.USER_NOT_LOGIN);
            }
            return false;
        }

        //用户已经登录，再检验权限
        // TODO: 2017/4/8 暂时不校验
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    public void setUnchekUrls(List<String> unchekUrls) {
        this.unchekUrls = unchekUrls;
    }
}
