package com.sample.springboot.microservices.common.code.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * User Id Dto
 * @author Manjunath Asundi
 */
@Setter
@Getter
@NoArgsConstructor
@ToString
public class UserIdDto {
    private Long id;
}