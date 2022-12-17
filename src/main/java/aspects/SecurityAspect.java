package aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Scanner;

@Aspect
public class SecurityAspect {
    private final String USERNAME = "root";
    private final String PASSWORD = "123";

    @Around("call(public void Application.start())")
    public void authenticationHandler(JoinPoint joinPoint, ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Scanner in = new Scanner(System.in);
        System.out.println("Authentication:");
        System.out.print("\tUsername: ");
        String username = in.next();
        System.out.print("\tPassword: ");
        String password = in.next();

        if(username.equals(this.USERNAME) && password.equals(this.PASSWORD))
            proceedingJoinPoint.proceed();
        else
            System.out.println("Access denied...");
    }
}
