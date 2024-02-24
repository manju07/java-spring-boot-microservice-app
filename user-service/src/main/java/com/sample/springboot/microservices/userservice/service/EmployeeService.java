package com.sample.springboot.microservices.userservice.service;

import com.sample.springboot.microservices.common.code.entity.User;
/**
 * @author Manjunath Asundi
 */
public interface EmployeeService {
    User addEmployee(User user) throws Exception;
}