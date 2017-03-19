package com.iag.aop;

import com.iag.annotation.ControllerLog;
import com.iag.enums.log.SystemLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * Created by beishan on 2017/3/19.
 */
@Aspect
@Component
public class LogAspect {

    //Controller 层日志注解切入类
    @Pointcut("@annotation(com.iag.annotation.ControllerLog)")
    public void controllerAspect(){

    }

    @Before("controllerAspect()")
    public void doControllerBefore(JoinPoint joinPoint) throws Exception{
        System.out.println("前置通知开始开始-------Controller-----" + LogAspect.getControllerMethodDescription(joinPoint));
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        RequestContext requestContext = new RequestContext(request);
        HttpSession session = request.getSession();
        /*
        //得到当前操作用户
        EtUser user = (EtUser) session.getAttribute("currentUser");

        String operator = "no user";
        String ip = "";
        String param = "";
        String url = "";

        if(user != null){
            operator = user.getUsername();
        }
        //get the log detail
        ip = request.getRemoteAddr();
        SystemLog systemLog = getControllerMethodDescription(joinPoint);
        param = "";
        url = request.getServletPath();
        //Object[] args = joinPoint.getArgs();
        EtLog log = new EtLog();

        log.setIp(ip);
        log.setOperationCode(systemLog.getCode());
        log.setOperation(requestContext.getMessage(systemLog.getCode()));
        log.setOperator(operator);
        log.setOperateTime(new Date());
        log.setParam(param);
        log.setUrl(url);
        log.setLogType(LogType.LOG_OPERATE.value());
        //write log to db
        serviceManager.getLogService().save(log);
        */
    }

    @After("controllerAspect()")
    public void doControllerAfter(JoinPoint joinPoint) throws Exception{
        System.out.println("后置通知开始开始-------Controller-----" + LogAspect.getControllerMethodDescription(joinPoint));

    }

    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     * @param joinPoint
     * @return method description
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
    public static SystemLog getControllerMethodDescription(JoinPoint joinPoint) throws Exception{
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        SystemLog systemLog = null;
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    systemLog = method.getAnnotation(ControllerLog.class).log();
                    break;
                }
            }
        }
        return systemLog;
    }
}
