package com.sample.springboot.microservices.common.code.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * BadgeDto
 * @author Manjunath asundi
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class BadgeDto {
    
    private Long id;

    private String name;

    private byte[] image;

}