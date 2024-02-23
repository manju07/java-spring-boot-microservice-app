package com.sample.springboot.microservices.common.code.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

/**
 * TeamDto
 * @author Manjunath asundi
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class TeamDto {
    private Long id;
    
    @NonNull
    @NotEmpty(message = "Team name should not be empty")
    private String name;
}