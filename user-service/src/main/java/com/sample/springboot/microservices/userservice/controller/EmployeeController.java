package com.sample.springboot.microservices.userservice.controller;

import com.sample.springboot.microservices.common.code.dto.EmployeeDto;
import com.sample.springboot.microservices.common.code.dto.UserDto;
import com.sample.springboot.microservices.common.code.entity.User;
import com.sample.springboot.microservices.userservice.service.EmployeeService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Employee API's
 * 
 * @author Manjunath Asundi
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/employee", produces = "application/json")
@Api(value = "Sample-App", description = "Employee operations")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ApiOperation(value = "Employee signup", response = UserDto.class)
    public ResponseEntity<UserDto> addEmployee(@RequestBody EmployeeDto employeeDto) throws Exception {
        User user = modelMapper.map(employeeDto, User.class);
        User returnUser = employeeService.addEmployee(user);
        UserDto returnUserDto = modelMapper.map(returnUser, UserDto.class);
        return new ResponseEntity<UserDto>(returnUserDto, HttpStatus.CREATED);
    }
}