package com.sample.springboot.microservices.oauth2authenticationserver.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * User entity 
 * @author Manjunath Asundi
 */
@Entity
@Table(name = "user")
@Where(clause = "is_deleted = false and is_enabled = true")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class User implements Serializable {

    private static final long serialVersionUID = 4163077184739255229L;

    @Id
    @GeneratedValue(generator = "user_seq_gen")
    @SequenceGenerator(name = "user_seq_gen", initialValue = 3, allocationSize = 1)
    private long id;

    @Column(name = "fname", nullable = false, length = 45)
    private String fName;

    @Column(name = "lname", nullable = false, length = 45)
    private String lName;

    @Column(nullable = false, unique = true, length = 15)
    private String phone;

    @Column(nullable = false, unique = true, length = 45)
    private String userName;

    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(nullable = false, length = 255)
    private String password;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdTime;

    @UpdateTimestamp
    private LocalDateTime updatedTime;

    private Boolean isDeleted = false;

    private Boolean isEnabled = false;

    @Column(nullable = false)
    private String gender;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = {
                    @JoinColumn(name = "role_id", referencedColumnName = "id") })
    private Role role;

    public User(String fName, String lName, String phone, String userName, String email, String password, Role role) {
        this.fName = fName;
        this.lName = lName;
        this.phone = phone;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(User user) {
        this.fName = user.fName;
        this.lName = user.lName;
        this.phone = user.phone;
        this.userName = user.userName;
        this.email = user.email;
        this.password = user.password;
        this.role = user.role;
    }

}