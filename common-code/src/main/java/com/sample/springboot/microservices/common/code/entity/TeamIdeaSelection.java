package com.sample.springboot.microservices.common.code.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * idea_selection entity
 * 
 * @author Manjunath Asundi
 */
@Entity
@Table(name = "team_idea_selection")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class TeamIdeaSelection implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "team_idea_selection_seq_gen")
    @SequenceGenerator(name = "team_idea_selection_seq_gen", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private Boolean ideate;

    @Column(nullable = false)
    private Boolean prototypePhase;

    @Column(nullable = false)
    private Boolean testPhase;

    @Column(nullable = false)
    private Boolean projectIdentification;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdTime;

    @UpdateTimestamp
    private LocalDateTime updatedTime;

    @Column(nullable = false, updatable = false)
    private String createdBy;

    @Column(nullable = false)
    private String updatedBy;

    public TeamIdeaSelection(Boolean ideate, Boolean prototypePhase, Boolean testPhase, Boolean projectIdentification,
            String createdBy, String updatedBy) {
        this.ideate = ideate;
        this.prototypePhase = prototypePhase;
        this.testPhase = testPhase;
        this.projectIdentification = projectIdentification;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }
}