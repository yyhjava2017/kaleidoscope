package com.user.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

        logger.error(joinPoint.getTarget().getClass()+"方法将执行"
        );
    }
}
