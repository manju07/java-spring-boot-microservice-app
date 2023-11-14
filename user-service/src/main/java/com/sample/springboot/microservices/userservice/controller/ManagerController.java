package com.sample.springboot.microservices.userservice.controller;

import java.util.Arrays;
import java.util.List;

import com.sample.springboot.microservices.common.code.entity.User;
import com.sample.springboot.microservices.common.code.exception.CustomException;
import com.sample.springboot.microservices.common.code.exception.ResourceNotFoundException;
import com.sample.springboot.microservices.common.code.model.UserArchiveResponse;
import com.sample.springboot.microservices.common.code.model.UserResponse;
import com.sample.springboot.microservices.userservice.service.ManagerService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * manager API's
 * 
 * @author Manjunath Asundi
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/admin/manager", produces = "application/json")
@PreAuthorize("hasRole('ROLE_ADMIN')")
@Api(value = "Sample-App", description = "Admin operations with managers")
@Slf4j
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    @ApiOperation(value = "Get all manager list", response = UserResponse.class, responseContainer = "List")
    public ResponseEntity<List<UserResponse>> getManagerList() throws CustomException {
        log.info("calling get manager list API");
        List<User> managerList = managerService.getManagerList();
        List<UserResponse> returnUserResponseList = Arrays.asList(modelMapper.map(managerList, UserResponse[].class));
        return new ResponseEntity<>(returnUserResponseList, HttpStatus.OK);
    }

    @GetMapping(value = "/{managerId}")
    @ApiOperation(value = "Get manager details by id", response = UserResponse.class)
    public ResponseEntity<UserResponse> getManagerById(@PathVariable("managerId") Long mId)
            throws ResourceNotFoundException, CustomException {
        log.info("calling get manager by id API");
        User managerDetails = managerService.getManagerById(mId);
        UserResponse userResponse  = modelMapper.map(managerDetails, UserResponse.class);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/{managerId}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Archive manager by id", response = UserArchiveResponse.class)
    public ResponseEntity<UserArchiveResponse> archiveManagerById(@PathVariable("managerId") Long managerId)
            throws ResourceNotFoundException, CustomException {
        log.info("calling archive manager by id API");
        managerService.archiveManager(managerId);
        UserArchiveResponse userArchiveResponse = new UserArchiveResponse(managerId, "manager archived successfully");
        return new ResponseEntity<UserArchiveResponse>(userArchiveResponse, HttpStatus.OK);
    }
}