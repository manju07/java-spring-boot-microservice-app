package com.sample.springboot.microservices.common.code.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * TeamIdeasSelectionDto
 * @author Manjunath Asundi
 */
@Setter
@Getter
@NoArgsConstructor
@ToString
public class TeamIdeasSelectionDto {

    private Long id;

    private Boolean ideate;

    private Boolean prototypePhase;

    private Boolean testPhase;

    private Boolean projectIdentification;
}