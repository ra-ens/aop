package com.abdelhakimrafik.springaop;

import com.abdelhakimrafik.springaop.security.SecurityContext;
import com.abdelhakimrafik.springaop.services.IBusiness;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.abdelhakimrafik.springaop"})
public class Application {

    public static void main(String[] args) {
        try {
            // Authenticate
            SecurityContext.authenticate("root", "123", new String[]{"ADMIN", "USER"});

            ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);

            IBusiness business = context.getBean(IBusiness.class);

            business.process();
            System.out.println(">>> " + business.compute());
        }
        catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
