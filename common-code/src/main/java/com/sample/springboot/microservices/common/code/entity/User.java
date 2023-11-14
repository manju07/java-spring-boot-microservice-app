package com.sample.springboot.microservices.common.code.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * User Entity
 * 
 * @author Manjunath Asundi
 */
@Entity(name = "user")
@Table(name = "user")
@NamedQueries(value = {
        @NamedQuery(name = "get_data_by_role", query = "select u from user u join u.role r where r.name=:role and u.createdBy=:createdBy") })
@SQLDelete(sql = "update user set is_deleted=true where id =?")
@Where(clause = "is_deleted=false")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 4163077184739255229L;

    @Id
    @GeneratedValue(generator = "user_seq_gen")
    @SequenceGenerator(name = "user_seq_gen", initialValue = 2, allocationSize = 1)
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

    @Column(updatable = false)
    private String createdBy;

    private String updatedBy;

    @Column(nullable = false)
    private String gender;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "allot_individual_badge", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "badge_id"))
    private Set<Badge> badgeSet = new HashSet<Badge>();

    public void addBadge(Badge badge) {
        badgeSet.add(badge);
    }

    public void removeBadge(Badge badge) {
        badgeSet.remove(badge);
    }

    @JsonBackReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "corporate_employee", joinColumns = {
            @JoinColumn(name = "employee_id", referencedColumnName = "id") }, inverseJoinColumns = {
                    @JoinColumn(name = "corporate_id", referencedColumnName = "id") })
    private Corporate corporate;

    @JsonBackReference
    @OneToMany(mappedBy = "engagementManager")
    private Set<Engagement> engagementList = new HashSet<Engagement>();

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = {
        @JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = {
                @JoinColumn(name = "role_id", referencedColumnName = "id") })
    private Role role;

    public User(String fName, String lName, String phone, String userName, String email, String password) {
        this.fName = fName;
        this.lName = lName;
        this.phone = phone;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public void addEngagement(Engagement engagement) {
        this.engagementList.add(engagement);
    }

    public void removeEngagement(Engagement engagement) {
        this.engagementList.remove(engagement);
    }

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