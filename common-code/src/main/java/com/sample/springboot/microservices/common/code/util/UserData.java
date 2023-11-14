package com.sample.springboot.microservices.common.code.util;

import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author Manjunath Asundi
 */
public class UserData {
    public static String getUserName() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
    }
}