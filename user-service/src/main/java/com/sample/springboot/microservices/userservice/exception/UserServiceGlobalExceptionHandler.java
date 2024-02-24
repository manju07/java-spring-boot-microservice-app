package com.sample.springboot.microservices.userservice.exception;

import java.sql.Timestamp;

import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sample.springboot.microservices.common.code.exception.CustomException;
import com.sample.springboot.microservices.common.code.exception.ErrorResponse;
import com.sample.springboot.microservices.common.code.exception.ResourceNotFoundException;

import lombok.extern.slf4j.Slf4j;

/**
 * The type Global exception handler.
 * 
 * @author Manjunath Asundi
 */
@ControllerAdvice
@Slf4j
public class UserServiceGlobalExceptionHandler extends ResponseEntityExceptionHandler {

  /**
   * Resource not found exception response entity.
   * 
   * @param exception type of exception
   * @param request   WebRequest
   * @return the response entity
   */
  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
    log.error(ex.getMessage(), ex);
    ErrorResponse errorDetails = new ErrorResponse(new Timestamp(System.currentTimeMillis()),
        HttpStatus.NOT_FOUND.value(), ex.getMessage(),
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
  @ExceptionHandler(value = {CustomException.class })
  public ResponseEntity<?> customExcpetionHandler(CustomException exception, WebRequest request) {
    log.error(exception.getMessage(), exception);
    ErrorResponse errorDetails = new ErrorResponse(new Timestamp(System.currentTimeMillis()),
        exception.getStatus(),
        exception.getMessage(), exception.getDetails());
    return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(value = { Exception.class })
  public ResponseEntity<?> globleExcpetionHandler(Exception exception, WebRequest request) {
    log.error(exception.getMessage(), exception);
    ErrorResponse errorDetails = new ErrorResponse(new Timestamp(System.currentTimeMillis()),
        HttpStatus.INTERNAL_SERVER_ERROR.value(),
        exception.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @Override
  protected ResponseEntity<Object> handleAsyncRequestTimeoutException(AsyncRequestTimeoutException ex,
      HttpHeaders headers, HttpStatus status, WebRequest webRequest) {
    log.error(ex.getMessage(), ex);
    ErrorResponse errorDetails = new ErrorResponse(new Timestamp(System.currentTimeMillis()),
        status.value(),
        ex.getMessage(), webRequest.getDescription(false));
    return new ResponseEntity<>(errorDetails, status);
  }

  @Override
  protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status,
      WebRequest request) {
    log.error(ex.getMessage(), ex);
    ErrorResponse errorDetails = new ErrorResponse(new Timestamp(System.currentTimeMillis()),
        status.value(),
        ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(errorDetails, status);
  }

  @Override
  protected ResponseEntity<Object> handleConversionNotSupported(ConversionNotSupportedException ex,
      HttpHeaders headers,
      HttpStatus status, WebRequest request) {
    log.error(ex.getMessage(), ex);
    ErrorResponse errorDetails = new ErrorResponse(new Timestamp(System.currentTimeMillis()),
        status.value(),
        ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(errorDetails, status);
  }

  @Override
  protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
      HttpStatus status, WebRequest request) {
    log.error(ex.getMessage(), ex);
    ErrorResponse errorDetails = new ErrorResponse(new Timestamp(System.currentTimeMillis()),
        status.value(),
        ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(errorDetails, status);
  }

  @Override
  protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex,
      HttpHeaders headers, HttpStatus status, WebRequest request) {
    log.error(ex.getMessage(), ex);
    ErrorResponse errorDetails = new ErrorResponse(new Timestamp(System.currentTimeMillis()),
        status.value(),
        ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(errorDetails, status);
  }

  @Override
  protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
      HttpHeaders headers, HttpStatus status, WebRequest request) {
    log.error(ex.getMessage(), ex);
    ErrorResponse errorDetails = new ErrorResponse(new Timestamp(System.currentTimeMillis()),
        status.value(),
        ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(errorDetails, status);
  }

  @Override
  protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
      HttpHeaders headers,
      HttpStatus status, WebRequest request) {
    log.error(ex.getMessage(), ex);
    ErrorResponse errorDetails = new ErrorResponse(new Timestamp(System.currentTimeMillis()),
        status.value(),
        ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(errorDetails, status);
  }

  @Override
  protected ResponseEntity<Object> handleHttpMessageNotWritable(HttpMessageNotWritableException ex,
      HttpHeaders headers,
      HttpStatus status, WebRequest request) {
    log.error(ex.getMessage(), ex);
    ErrorResponse errorDetails = new ErrorResponse(new Timestamp(System.currentTimeMillis()),
        status.value(),
        ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(errorDetails, status);
  }

  @Override
  protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
      HttpHeaders headers, HttpStatus status, WebRequest request) {
    log.error(ex.getMessage(), ex);
    ErrorResponse errorDetails = new ErrorResponse(new Timestamp(System.currentTimeMillis()),
        status.value(),
        ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(errorDetails, status);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
      HttpHeaders headers,
      HttpStatus status, WebRequest request) {
    log.error(ex.getMessage(), ex);
    ErrorResponse errorDetails = new ErrorResponse(new Timestamp(System.currentTimeMillis()),
        status.value(),
        ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(errorDetails, status);
  }

  @Override
  protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
      HttpStatus status, WebRequest request) {
    log.error(ex.getMessage(), ex);
    ErrorResponse errorDetails = new ErrorResponse(new Timestamp(System.currentTimeMillis()),
        status.value(),
        ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(errorDetails, status);
  }

  @Override
  protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
      HttpHeaders headers, HttpStatus status, WebRequest request) {
    log.error(ex.getMessage(), ex);
    ErrorResponse errorDetails = new ErrorResponse(new Timestamp(System.currentTimeMillis()),
        status.value(),
        ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(errorDetails, status);
  }

  @Override
  protected ResponseEntity<Object> handleMissingServletRequestPart(MissingServletRequestPartException ex,
      HttpHeaders headers, HttpStatus status, WebRequest request) {
    log.error(ex.getMessage(), ex);
    ErrorResponse errorDetails = new ErrorResponse(new Timestamp(System.currentTimeMillis()),
        status.value(),
        ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(errorDetails, status);
  }

  @Override
  protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
      HttpStatus status, WebRequest request) {
    log.error(ex.getMessage(), ex);
    ErrorResponse errorDetails = new ErrorResponse(new Timestamp(System.currentTimeMillis()),
        status.value(),
        ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(errorDetails, status);
  }

  @Override
  protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException ex,
      HttpHeaders headers, HttpStatus status, WebRequest request) {
    log.error(ex.getMessage(), ex);
    ErrorResponse errorDetails = new ErrorResponse(new Timestamp(System.currentTimeMillis()),
        status.value(),
        ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(errorDetails, status);
  }

  @Override
  protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
      HttpStatus status,
      WebRequest request) {
    log.error(ex.getMessage(), ex);
    ErrorResponse errorDetails = new ErrorResponse(new Timestamp(System.currentTimeMillis()),
        status.value(),
        ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(errorDetails, status);
  }
}