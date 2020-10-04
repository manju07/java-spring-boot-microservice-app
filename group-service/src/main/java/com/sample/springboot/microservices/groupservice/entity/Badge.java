package com.sample.springboot.microservices.groupservice.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Badge entity
 * @author Manjunath Asundi
 */
@Entity(name = "badge")
@Table(name = "badge")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Badge implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -2485819965846011056L;

    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Lob
    @Column(nullable=false, columnDefinition="mediumblob")
    private byte[] image;
}