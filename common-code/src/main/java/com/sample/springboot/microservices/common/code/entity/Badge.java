package com.sample.springboot.microservices.common.code.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

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