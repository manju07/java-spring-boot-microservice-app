package com.sample.springboot.microservices.common.code.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * CorporateDto
 * @author Manjunath Asundi
 */
@Setter
@Getter
@NoArgsConstructor
@ToString
public class CorporateDto {

    private Long id;

    private String name;

    private String clientSpocName;

    private String clientSpocPhone;
    
    private String clientSpocEmail;

    private String gst;

    private AddressDto address;

    private List<CorporateDomainDto> corporateDomainList = new ArrayList<CorporateDomainDto>();
}