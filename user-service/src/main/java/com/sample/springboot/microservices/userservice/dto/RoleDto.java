package com.sample.springboot.microservices.userservice.dto;

import com.sample.springboot.microservices.userservice.entity.constant.UserRole;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
 * @author Manjunath Asundi
 */
@Setter
@Getter
@NoArgsConstructor
@ToString
public class RoleDto {
    private UserRole name;
}