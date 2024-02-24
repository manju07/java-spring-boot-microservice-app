package com.sample.springboot.microservices.common.code.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Address Entity
 * 
 * @author Manjunath Asundi
 */
@Entity
@Table(name = "address")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address implements Serializable {

    private static final long serialVersionUID = -6873361542528746767L;

    @Id
    @GeneratedValue(generator = "address_seq_gen")
    @SequenceGenerator(name = "address_seq_gen", initialValue = 2, allocationSize = 1)
    private Long id;

    @Column(nullable = false, length = 100)
    private String area;

    @Column(nullable = false, length = 45)
    private String city;

    @Column(nullable = false, length = 45)
    private String pincode;

    @Column(nullable = false, length = 45)
    private String state;

    @Column(nullable = false, length = 45)
    private String country;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime created_time;

    @UpdateTimestamp
    private LocalDateTime updated_time;

    @JsonBackReference
    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    private Corporate corporate;
}