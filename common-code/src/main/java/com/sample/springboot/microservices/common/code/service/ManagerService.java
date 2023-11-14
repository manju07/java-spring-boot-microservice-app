package com.sample.springboot.microservices.common.code.service;

import java.util.List;

import com.sample.springboot.microservices.common.code.entity.User;
import com.sample.springboot.microservices.common.code.exception.ResourceNotFoundException;
import com.sample.springboot.microservices.common.code.exception.CustomException;


/**
 * ManagerService
 * @author Manjunath Asundi
 */
public interface ManagerService {
    User getManagerById(Long managerId) throws ResourceNotFoundException, CustomException;
    List<User> getManagerList() throws CustomException;
    Boolean archiveManager(Long managerId) throws ResourceNotFoundException,CustomException;
}