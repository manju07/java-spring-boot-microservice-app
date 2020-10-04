package com.sample.springboot.microservices.groupservice.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * @author Manjunath Asundi
 */
@Setter
@Getter
@NoArgsConstructor
public class TeamDeleteResponse implements Serializable {
    /**
    *
    */
    private static final long serialVersionUID = 1L;
    private Long id;
    private String status;
}