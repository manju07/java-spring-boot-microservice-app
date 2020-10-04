package com.sample.springboot.microservices.oauth2authenticationserver.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sample.springboot.microservices.oauth2authenticationserver.model.UserRole;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Role entity
 * @author Manjunath Asundi
 */
@Entity
@Table(name = "role")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Role implements Serializable {

    private static final long serialVersionUID = 8048547818296988457L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name", updatable = false)
    private UserRole name;

    @OneToMany(mappedBy = "role")
    @JsonBackReference
    private List<User> userList = new ArrayList<User>();
}