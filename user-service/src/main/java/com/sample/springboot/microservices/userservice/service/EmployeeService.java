package com.sample.springboot.microservices.userservice.service;

import com.sample.springboot.microservices.userservice.entity.User;
import com.sample.springboot.microservices.userservice.exception.CustomException;
/**
 * @author Manjunath Asundi
 */
public interface EmployeeService {
    User addEmployee(User user) throws CustomException;
}