package com.abdelhakimrafik.springaop.aspects;

import com.abdelhakimrafik.springaop.security.SecurityContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy
public class HasAspect {

    @Around(value = "@annotation(has)", argNames = "joinPoint,has")
    public Object hasRoles(ProceedingJoinPoint joinPoint, Has has) throws Throwable {
        String[] roles = has.roles();
        boolean authorized = false;

        for (String r : roles)
            if (SecurityContext.hasRole(r)) authorized = true;

        if (!authorized) throw new RuntimeException(String.format(
                "Unauthorized: You don't have permissions to execute %s method",
                joinPoint.getSignature().getName()
        ));

        Object o = joinPoint.proceed();

        return o;
    }

}
