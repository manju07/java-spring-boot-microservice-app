package com.sample.springboot.microservices.common.code.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
/**
 * @author Manjunath Asundi
 */
@Setter
@Getter
@NoArgsConstructor
@ToString
public class IdeaDto implements Serializable {

    private static final long serialVersionUID = 268458047795099831L;

    private Long teamId;

    private Long ideaId;

    private String ideate;

    private String prototypePhase;

    private String testPhase;

    public IdeaDto(Long teamId, Long ideaId, String ideate, String prototypePhase, String testPhase) {
        this.teamId = teamId;
        this.ideaId = ideaId;
        this.ideate = ideate;
        this.prototypePhase = prototypePhase;
        this.testPhase = testPhase;
    }
}