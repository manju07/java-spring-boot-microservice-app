package com.sample.springboot.microservices.userservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * @author Manjunath Asundi
 */
@Setter
@Getter
@NoArgsConstructor
public class UserArchiveResponse {
    
    private Long id;

    private String status;

    public UserArchiveResponse(Long id, String status) {
        this.id = id;
        this.status = status;
    }
}