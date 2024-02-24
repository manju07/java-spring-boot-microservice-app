package com.sample.springboot.microservices.userservice.service;

import java.util.List;

import com.sample.springboot.microservices.common.code.entity.User;
import com.sample.springboot.microservices.common.code.exception.CustomException;
import com.sample.springboot.microservices.common.code.exception.ResourceNotFoundException;
import com.sample.springboot.microservices.userservice.repository.UserRepository;
import com.sample.springboot.microservices.userservice.util.UserData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * Manager service implementation
 * 
 * @author Manjunath Asundi
 */

@Service
@Slf4j
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Boolean archiveManager(Long managerId) throws ResourceNotFoundException, CustomException {
        try {
            User user = userRepository.findById(managerId)
                    .orElseThrow(() -> new ResourceNotFoundException("Manager doesn't exist with id:" + managerId));
            user.setIsDeleted(true);
            user.setUpdatedBy(UserData.getUserName());
            userRepository.save(user);
            log.info("Manager deleted with Id:{}", managerId);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public User getManagerById(Long managerId) throws ResourceNotFoundException, CustomException {
        try {
            return userRepository.getManagerById(managerId)
                    .orElseThrow(() -> new ResourceNotFoundException("Manager doesn't exist with id:" + managerId));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public List<User> getManagerList() throws CustomException {
        try {
            return userRepository.getManagerList();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }
}