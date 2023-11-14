package com.sample.springboot.microservices.common.code.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * CorporateDomainDto
 * @author Manjunath Asundi
 */
@Setter
@Getter
@NoArgsConstructor
@ToString
public class CorporateDomainDto {
    
    private Long id;
    private String name;
}