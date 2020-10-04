package com.sample.springboot.microservices.groupservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
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
    private String name;
}