package com.sample.springboot.microservices.common.code.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Manjunath Asundi
 */
@Setter
@Getter
@NoArgsConstructor
public class CorporateArchiveResponse {

    private Long id;

    private String status;

    public CorporateArchiveResponse(Long id, String status) {
        this.id = id;
        this.status = status;
    }
}