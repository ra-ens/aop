package com.abdelhakimrafik.springaop.security;

public class SecurityContext {
    private static String username;
    private static String password;
    private static String[] roles;


    public static void authenticate(String username, String password, String[] roles) {
        if(!username.equals("root") || !password.equals("123")) throw new RuntimeException("Access Denied!!");

        SecurityContext.username = username;
        SecurityContext.password = password;
        SecurityContext.roles = roles;
    }

    public static boolean hasRole(String role) {
        for (String r: roles)
            if(r.equals(role)) return true;
        return false;
    }
}
