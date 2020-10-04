package com.sample.springboot.microservices.userservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * User Dto Entity
 * 
 * @author Manjunath Asundi
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
public class UserDto {
    
    private Long id;

    private String fName;

    private String lName;

    private String phone;

    private String userName;

    private String email;

    private String gender;
    
}