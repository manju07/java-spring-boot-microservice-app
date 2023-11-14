package com.sample.springboot.microservices.common.code.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * User Add Dto 
 * 
 * @author Manjunath Asundi
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
public class UserAddDto {

    private Long id;

    private String fName;

    private String lName;

    private String phone;

    private String userName;

    private String email;

    private String gender;

    private String password;

    private RoleDto role;

    private CorporateIdDto corporate;
}