package com.abdelhakimrafik.springaop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.logging.Logger;

@Aspect
@Component
@EnableAspectJAutoProxy
public class LogAspect {

    Logger logger = Logger.getLogger(LogAspect.class.getName());

    @Around("@annotation(Log)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object o = joinPoint.proceed();
        logger.info(String.format(
                "%s [%s] : %s",
                new Date().toString(),
                (System.currentTimeMillis() - startTime),
                joinPoint.getSignature().getName()
        ));
        return o;
    }
}
