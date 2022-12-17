package aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.io.IOException;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

@Aspect
public class Log {
    private Long execStartTime;
    private Logger logger = Logger.getLogger(this.getClass().getName());
    public Log() throws IOException {
        logger.addHandler(new FileHandler("log.xml"));
        logger.setUseParentHandlers(false);
    }
    @Pointcut("execution(* services.*.*(..))")
    public void allServiceMethods(){}

    @Before("allServiceMethods()")
    public void beforeAllServiceMethods(JoinPoint joinPoint){
        execStartTime = System.currentTimeMillis();
    }

    @After("allServiceMethods()")
    public void afterAllServiceMethods(JoinPoint joinPoint){
        logger.info(String.format(
                "%s : %s executed for %sms",
                new Date().toString(),
                joinPoint.getSignature().getName(),
                System.currentTimeMillis() - execStartTime
        ));
    }
}
