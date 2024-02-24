package com.sample.springboot.microservices.common.code.exception;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Manjunath Asundi
 */
@AllArgsConstructor
@Setter
@Getter
@ToString
public class CustomException extends Exception {

    private static final long serialVersionUID = 7108160092721922439L;

    private Timestamp timestamp;
    private int status;
    private String message;
    private String details;

    public CustomException(String details) {
        super(details);
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.message = "Internal Server Error";
        this.status = 500;
        this.details = details;
    }

    public CustomException(String message, int status, String details) {
        super(details);
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.status = status;
        this.message = message;
        this.details = details;
    }
}