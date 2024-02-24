package com.sample.springboot.microservices.common.code.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author Manjunath Asundi
 */
@Entity(name = "corporate")
@Table(name = "corporate")
@SQLDelete(sql = "update corporate set is_deleted = true where id =?")
@Where(clause = "is_deleted=false")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Corporate implements Serializable {

    private static final long serialVersionUID = -5061619076595017130L;

    @Id
    @GeneratedValue(generator = "corporate_seq_gen")
    @SequenceGenerator(name = "corporate_seq_gen", initialValue = 2, allocationSize = 1)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @Column(nullable = false)
    private String clientSpocName;

    @Column(nullable = false, unique = true, length = 15)
    private String clientSpocPhone;

    @Column(nullable = false, unique = true, length = 100)
    private String clientSpocEmail;

    @Column(nullable = false, unique = true, length = 100)
    private String gst;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime created_time;

    @UpdateTimestamp
    private LocalDateTime updated_time;

    @CreatedBy
    @Column(nullable = true, updatable = false)
    private String createdBy;

    @Column(nullable = true)
    @LastModifiedBy
    private String updatedBy;

    @Column(columnDefinition = "tinyint default 0" )
    private Boolean isDeleted = false;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.PERSIST)
    private Address address;

    @JsonManagedReference
    @OneToMany(mappedBy = "corporate")
    private List<User> employeeList = new ArrayList<User>();

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "corporate")
    @JsonManagedReference
    private List<Engagement> engagementList = new ArrayList<Engagement>();

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "corporate")
    private List<CorporateDomain> corporateDomainList = new ArrayList<CorporateDomain>();

    public void addEngagement(Engagement engagement) {
        this.engagementList.add(engagement);
    }

    public void removeEngagement(Engagement engagement) {
        this.engagementList.remove(engagement);
    }

    public void addEmployee(User user) {
        this.employeeList.add(user);
    }

    public void removeEmployee(User user) {
        this.employeeList.remove(user);
    }

    public void addCorporateDomain(CorporateDomain corporateDomain) {
        this.corporateDomainList.add(corporateDomain);
    }

    public void removeCorporateDomain(CorporateDomain corporateDomain) {
        this.corporateDomainList.remove(corporateDomain);
    }
}