package com.sample.springboot.microservices.common.code.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * EngagementModule entity
 * 
 * @author Manjunath Asundi
 */
@Entity
@Table(name = "module")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Module implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @JsonBackReference
    @ManyToMany(mappedBy = "moduleList")
    private List<Engagement> engagementList = new ArrayList<Engagement>();

    public void addEngagement(Engagement engagement) {
        this.engagementList.add(engagement);
    }

    public void removeEngagement(Engagement engagement) {
        this.engagementList.remove(engagement);
    }
}