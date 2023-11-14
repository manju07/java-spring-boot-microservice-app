package com.sample.springboot.microservices.common.code.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
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