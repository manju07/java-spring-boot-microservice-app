package com.sample.springboot.microservices.common.code.exception;

/**
 * Custom ResourceNotFoundException
 * @author Manjunath Asundi
 */
public class ResourceNotFoundException extends Exception {

    private static final long serialVersionUID = -1329008876853838231L;

    public ResourceNotFoundException(String exceptionString) {
        super(exceptionString);
    }
}   