package com.sample.springboot.microservices.groupservice.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.sample.springboot.microservices.common.code.exception.CustomException;
import com.sample.springboot.microservices.common.code.exception.ErrorResponse;
import com.sample.springboot.microservices.common.code.exception.ResourceNotFoundException;

/**
 * The type Global exception handler.
 * 
 * @author Manjunath Asundi
 */
@ControllerAdvice
public class GlobalExceptionHandler {

  /**
   * Resource not found exception response entity.
   * 
   * @param exception type of exception
   * @param request   WebRequest
   * @return the response entity
   */
  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
    ErrorResponse errorDetails = new ErrorResponse(new Date(), HttpStatus.NOT_FOUND.toString(), ex.getMessage(),
        request.getDescription(false));
    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
  }

  /**
   * Globle excpetion handler response entity.
   * 
   * @param exception type of exception
   * @param request   WebRequest
   * @return the response entity
   */
  @ExceptionHandler(value = { Exception.class, CustomException.class })
  public ResponseEntity<?> globleExcpetionHandler(Exception exception, WebRequest request) {
    ErrorResponse errorDetails = new ErrorResponse(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.toString(),
        exception.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}