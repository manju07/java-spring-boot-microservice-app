package com.sample.springboot.microservices.common.code.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * TeamIdeasDto
 * @author Manjunath Asundi
 */
@Setter
@Getter
@NoArgsConstructor
@ToString
public class TeamIdeasDto {

    private Long id;

    private String ideate;

    private String prototypePhase;

    private String testPhase;
}