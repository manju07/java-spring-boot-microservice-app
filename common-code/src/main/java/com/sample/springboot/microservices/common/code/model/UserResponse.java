package com.sample.springboot.microservices.common.code.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * UserResponse
 * @author Manjunath Asundi
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserResponse {

    private Long id;

    private String fName;

    private String lName;

    private String phone;

    private String userName;

    private String email;

    private String gender;
}