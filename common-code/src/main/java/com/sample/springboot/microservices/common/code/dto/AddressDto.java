package com.sample.springboot.microservices.common.code.dto;

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
public class AddressDto {
    private Long id;

    private String area;

    private String city;

    private String pincode;

    private String state;

    private String country;
}