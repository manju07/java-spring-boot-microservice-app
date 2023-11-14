package com.sample.springboot.microservices.common.code.service;

import com.sample.springboot.microservices.common.code.entity.User;
import com.sample.springboot.microservices.common.code.exception.CustomException;

/**
 * @author Manjunath Asundi
 */
public interface EmployeeService {
    User addEmployee(User user) throws CustomException;
}