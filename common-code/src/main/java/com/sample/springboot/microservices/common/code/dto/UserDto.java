package com.sample.springboot.microservices.common.code.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
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

    @NonNull
    @NotEmpty
    private String fName;

    @NonNull
    @NotEmpty
    private String lName;

    @NonNull
    @NotEmpty
    private String phone;

    @NonNull
    @NotEmpty
    private String userName;

    @Email
    private String email;

    private String gender;

}