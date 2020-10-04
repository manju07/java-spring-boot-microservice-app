package com.sample.springboot.microservices.oauth2authenticationserver.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author Manjunath Asundi
 */
@RestController
public class TestController {
    
    @GetMapping("/test")
    public String test(Principal principal) {
        return "Login user:"+ principal.getName();
    }
}