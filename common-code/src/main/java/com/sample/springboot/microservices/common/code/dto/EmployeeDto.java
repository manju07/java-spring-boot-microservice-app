package com.sample.springboot.microservices.common.code.dto;

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
public class EmployeeDto {
    
    private Long id;

    private String fName;

    private String lName;

    private String phone;

    private String userName;

    private String email;

    private String gender;

    private String password;

    private CorporateIdDto corporate;
    
}