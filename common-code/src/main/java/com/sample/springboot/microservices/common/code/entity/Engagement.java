package com.sample.springboot.microservices.common.code.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sample.springboot.microservices.common.code.entity.constant.ServiceOffering;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Engagement
 * 
 * @author Manjunath Asundi
 */
@Entity(name = "engagement")
@Table(name = "engagement")
@SQLDelete(sql = "update engagement set is_deleted = true where id =?")
@Where(clause = "is_deleted=false")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Engagement implements Serializable {

    private static final long serialVersionUID = -7917141913045221767L;

    @Id
    @GeneratedValue(generator = "engagement_seq_gen")
    @SequenceGenerator(name = "engagement_seq_gen", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, updatable = false)
    private ServiceOffering serviceOffering;

    @Column(nullable = false)
    private String clientSpocName;

    @Column(nullable = false, length = 15)
    private String clientSpocPhone;

    @Column(nullable = false, length = 100)
    private String clientSpocEmail;

    @Column(nullable = false)
    private Double contractAmount;

    @OneToOne
    @JsonBackReference
    private Corporate corporate;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    private User engagementManager;

    private Boolean isDeleted = false;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "engagement")
    private List<CheckpointReviewer> checkpointList = new ArrayList<CheckpointReviewer>();

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "engagement", fetch = FetchType.EAGER)
    private List<EngagementStatus> engagementStatusList = new ArrayList<EngagementStatus>();

    @JsonManagedReference
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "engagement_module", joinColumns = {
            @JoinColumn(name = "engagement_id", referencedColumnName = "id") }, inverseJoinColumns = {
                    @JoinColumn(name = "module_id", referencedColumnName = "id") })
    private List<Module> moduleList = new ArrayList<Module>();

    public void addModule(Module module) {
        this.moduleList.add(module);
    }

    public void removeModule(Module module) {
        this.moduleList.remove(module);
    }

    public void addEngagementStatus(EngagementStatus engagementStatus) {
        this.engagementStatusList.add(engagementStatus);
    }

    public void removeEngagementStatus(EngagementStatus engagementStatus) {
        this.engagementStatusList.remove(engagementStatus);
    }

    public void addAllCheckpointList(List<CheckpointReviewer> checkpointReviewerList) {
        this.checkpointList.addAll(checkpointReviewerList);
    }

    public void addCheckpoint(CheckpointReviewer checkpointReviewer) {
        this.checkpointList.add(checkpointReviewer);
    }

    public void removeCheckpoint(CheckpointReviewer checkpointReviewer) {
        this.checkpointList.remove(checkpointReviewer);
    }
}