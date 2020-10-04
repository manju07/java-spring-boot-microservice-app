package com.sample.springboot.microservices.groupservice.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * virtual_wall_ideas entity
 * 
 * @author Manjunath Asundi
 */
@Entity
@Table(name = "team_virtual_wall_ideas")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class TeamVirtualWallIdeas implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 7171136590706603223L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;
}