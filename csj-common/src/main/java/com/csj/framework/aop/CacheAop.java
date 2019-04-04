package com.csj.framework.aop;

import com.csj.framework.annotation.CsjCache;
import com.csj.framework.utils.ElParser;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class CacheAop {

    @Around("@annotation(csjCache)")
    public Object cacheAdvise(ProceedingJoinPoint pjp, CsjCache csjCache) throws Throwable {

        Object result;
        synchronized (this) {
            result=pjp.proceed();
        }
        return result;
    }


    private String getKey(String key, ProceedingJoinPoint pjp) {
        Method method = ((MethodSignature) pjp.getSignature()).getMethod();
        String[] parameterNames = new LocalVariableTableParameterNameDiscoverer().getParameterNames(method);
        return ElParser.getKey(key, parameterNames, pjp.getArgs());
    }


}
