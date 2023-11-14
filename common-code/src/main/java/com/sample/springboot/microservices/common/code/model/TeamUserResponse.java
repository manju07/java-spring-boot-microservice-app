package com.sample.springboot.microservices.common.code.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * TeamUserResponse
 * @author Manjunath asundi
 */
@Setter
@Getter
@NoArgsConstructor
@ToString
public class TeamUserResponse {
    private Long teamId;
    private Long userId;
    private String status;
}