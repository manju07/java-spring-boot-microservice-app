package com.sample.springboot.microservices.common.code.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Engagement status entity
 * 
 * @author Manjunath Asundi
 */

@Entity
@Table(name = "engagement_status")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class EngagementStatus implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "engagement_status_seq_gen")
    @SequenceGenerator(name = "engagement_status_seq_gen", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private byte stageId;

    @Column(nullable = false)
    private String name;

    private String completionStatus;

    private String signOffStatus;

    @Column(nullable = false)
    private LocalDateTime plannedStartDate;

    @Column(nullable = false)
    private LocalDateTime plannedEndDate;

    private LocalDateTime actualStartDate;

    private LocalDateTime actualEndDate;

    private String status;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    private Engagement engagement;
}