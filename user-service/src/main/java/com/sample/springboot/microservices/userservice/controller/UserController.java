package com.sample.springboot.microservices.userservice.controller;

import com.sample.springboot.microservices.common.code.dto.UserAddDto;
import com.sample.springboot.microservices.common.code.entity.User;
import com.sample.springboot.microservices.common.code.exception.CustomException;
import com.sample.springboot.microservices.common.code.exception.ResourceNotFoundException;
import com.sample.springboot.microservices.common.code.model.UserResponse;
import com.sample.springboot.microservices.userservice.service.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * User management API's
 * 
 * @author Manjunath Asundi
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/admin/user", produces = "application/json")
@PreAuthorize("hasRole('ROLE_ADMIN')")
@Api(value = "Sample-App", description = "Admin operations with managers")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ApiOperation(value = "Admin will create a manager/partner account", response = UserResponse.class)
    public ResponseEntity<UserResponse> addUser(@RequestBody UserAddDto userAddDto)
            throws CustomException, ResourceNotFoundException {
        log.info("calling add user API");
        User user = modelMapper.map(userAddDto, User.class);
        User returnUser = userService.addUser(user);
        UserResponse userResponse = modelMapper.map(returnUser, UserResponse.class);
        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{userId}")
    @ApiOperation(value = "Update user details", response = UserResponse.class)
    public ResponseEntity<UserResponse> updateManagerById(@PathVariable("userId") Long userId,
            @RequestBody UserAddDto userAddDto) throws ResourceNotFoundException, CustomException {
        log.info("calling update user API");
        User user = modelMapper.map(userAddDto, User.class);
        User returnUser = userService.updateUser(userId, user);
        UserResponse userResponse = modelMapper.map(returnUser, UserResponse.class);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }
}