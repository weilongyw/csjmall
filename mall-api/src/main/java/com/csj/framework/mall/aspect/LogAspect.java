package com.csj.framework.mall.aspect;

import com.alibaba.fastjson.JSON;
import com.csj.framework.mall.exception.BizException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.ExtendedServletRequestDataBinder;

import javax.servlet.http.HttpServletResponseWrapper;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Component
@Aspect
public class LogAspect {

    Logger log = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(* com.csj.framework.mall.controller.*.*(..))")
    public void log() {
    }


    @Around(value = "log()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //通过uuid关联请求参数和返回参数
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        methodBefore(proceedingJoinPoint, uuid);
        Object proceed = null;
        try {
            proceed = proceedingJoinPoint.proceed();
        } catch (BizException e) {
            log.error("[{}] AOP methodAfterThrowing:{}", uuid, e.getErrorMessage());
            throw e;
        } catch (Exception e) {
            log.error("[{}] AOP methodAfterThrowing:", uuid);
            throw e;
        }
        methodAfterReturing(proceed, uuid);
        return proceed;
    }

    public void methodBefore(ProceedingJoinPoint joinPoint, String uuid) {
        // 打印请求内容
        try {
            // 下面两个数组中，参数值和参数名的个数和位置是一一对应的。
            Object[] objs = joinPoint.getArgs();
            String[] argNames = ((MethodSignature) joinPoint.getSignature()).getParameterNames(); // 参数名
            Map<String, Object> paramMap = new HashMap<>();
            for (int i = 0; i < objs.length; i++) {
                if (!(objs[i] instanceof ExtendedServletRequestDataBinder) && !(objs[i] instanceof HttpServletResponseWrapper)) {
                    paramMap.put(argNames[i], objs[i]);
                }
            }
            log.info("[{}] 方法:{}参数:{}", uuid, joinPoint.getSignature(), paramMap);
        } catch (Exception e) {
            log.error("[{}] AOP methodBefore:", uuid, e, e.getMessage());
        }
    }

    public void methodAfterReturing(Object o, String uuid) {
        try {
            if (o != null) {
                log.info("[{}] Response内容:{}", uuid, JSON.toJSONString(o));
            }
        } catch (Exception e) {
            log.error("[{}] AOP methodAfterReturing:", uuid, e);
        }
    }


}
