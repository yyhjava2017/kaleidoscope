package com.user.aspect;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @zz yyh
 * @time 2020-08
 */
@Component
@Aspect
public class UserAspect {

    Logger logger = LoggerFactory.getLogger(getClass());
    @Pointcut("execution(* com.user.service.*.*(..))")
    public void log(){
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        logger.error(joinPoint.getTarget().getClass()+"方法将执行");
    }
}
