package com.csj.framework.mall.aspect;


import com.csj.framework.mall.annotation.RequirePermission;
import com.csj.framework.mall.exception.BizException;
import com.csj.framework.mall.exception.ErrorEnum;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class LoginAspect {


    @Autowired
    RedisTemplate redisTemplate;


    @Pointcut(value = "@annotation( com.csj.framework.mall.annotation.RequirePermission)")
    public void loginAspect() {
    }

    @Around("loginAspect()")
    public Object beforeOperation(ProceedingJoinPoint joinPoint) throws Throwable {
        RequirePermission requirePermission = ((MethodSignature) joinPoint.getSignature()).getMethod().getAnnotation(RequirePermission.class);
        String value = requirePermission.value();
        String[] permissions = value.split(",");
        for (String per : permissions) {
            if (per.equals("login")) {
                checkLogin();
            }
        }
        return joinPoint.proceed();
    }


    public void checkLogin() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("token");
        if (null != token && !token.equals("")) {
            Boolean aBoolean = redisTemplate.hasKey(token);
            if (!aBoolean) {
                throw new BizException(ErrorEnum.LOGIN_EXPIRED);
            }
        } else {
            throw new BizException(ErrorEnum.LOGIN_EXPIRED);
        }
    }


}
