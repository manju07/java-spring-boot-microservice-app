package com.sample.springboot.microservices.common.code.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Corporate Domain entity
 * 
 * @author Manjunath Asundi
 */
@Entity
@Table(name = "corporate_domain")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class CorporateDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "corporate_domain_seq_gen")
    @SequenceGenerator(name = "corporate_domain_seq_gen", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;
    
    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY)
    private Corporate corporate;
    
}