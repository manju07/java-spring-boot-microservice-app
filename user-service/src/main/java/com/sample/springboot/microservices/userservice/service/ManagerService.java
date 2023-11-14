package com.sample.springboot.microservices.userservice.service;

import java.util.List;

import com.sample.springboot.microservices.common.code.entity.User;
import com.sample.springboot.microservices.common.code.exception.CustomException;
import com.sample.springboot.microservices.common.code.exception.ResourceNotFoundException;


/**
 * ManagerService
 * @author Manjunath Asundi
 */
public interface ManagerService {
    User getManagerById(Long managerId) throws ResourceNotFoundException, CustomException;
    List<User> getManagerList() throws CustomException;
    Boolean archiveManager(Long managerId) throws ResourceNotFoundException,CustomException;
}