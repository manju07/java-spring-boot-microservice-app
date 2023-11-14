package com.sample.springboot.microservices.common.code.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * EngagementArchiveResponse
 * @author Manjunath Asundi
 */
@Setter
@Getter
@NoArgsConstructor
public class EngagementArchiveResponse {

    private Long id;

    private String status;

    public EngagementArchiveResponse(Long id, String status) {
        this.id = id;
        this.status = status;
    }
}