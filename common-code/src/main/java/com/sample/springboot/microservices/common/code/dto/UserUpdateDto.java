package com.sample.springboot.microservices.common.code.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Manager Dto Entity
 * 
 * @author Manjunath Asundi
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
public class UserUpdateDto {

    private Long id;

    private String fName;

    private String lName;

    private String gender;

    private RoleDto role;

    private CorporateIdDto corporate;
}