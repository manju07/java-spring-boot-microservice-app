package com.sample.springboot.microservices.common.code.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sample.springboot.microservices.common.code.entity.constant.FrequencyType;
import com.sample.springboot.microservices.common.code.entity.constant.ReviewerRole;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * checkpoint reviewer entity
 * @author Manjunath Asundi
 */
@Entity
@Table(name = "checkpoint_reviewer")
@Setter
@Getter
@NoArgsConstructor
public class CheckpointReviewer {
    
    @Id
    @GeneratedValue(generator = "checkpoint_reviewer_seq_gen")
    @SequenceGenerator(name = "checkpoint_reviewer_seq_gen", initialValue = 1, allocationSize = 1)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReviewerRole reviewerRole;
    
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FrequencyType frequency;
 
    @JsonBackReference
    @OneToOne
    private Engagement engagement;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)

    private LocalDateTime createdTime;

    @UpdateTimestamp
    private LocalDateTime updatedTime;

    @CreatedBy
    @Column(nullable = true, updatable = false)
    private String createdBy;

    @LastModifiedBy
    @Column(nullable = true)
    private String updatedBy;

    public CheckpointReviewer(ReviewerRole reviewerRole, String name, String email, FrequencyType frequency) {
        this.reviewerRole = reviewerRole;
        this.name = name;
        this.email = email;
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "CheckpointReviewer [email=" + email + ", frequency=" + frequency + ", id=" + id + ", name=" + name
                + ", reviewerRole=" + reviewerRole + "]";
    }
}