package com.sample.springboot.microservices.common.code.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Manjunath Asundi
 */
@Entity
@Table(name = "team")
@Getter
@Setter
@NoArgsConstructor
@SQLDelete(sql = "update team set is_deleted=true where id =?")
@Where(clause = "is_deleted=false")
public class Team implements Serializable {

    private static final long serialVersionUID = 2933819373571040607L;

    @Id
    @GeneratedValue(generator = "team_seq_gen")
    @SequenceGenerator(name = "team_seq_gen", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(unique = true, nullable = false, length = 45)
    private String name;

    @Column(nullable = false)
    Boolean isDeleted = false;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdTime;

    @UpdateTimestamp
    private LocalDateTime updatedTime;

    @CreatedBy
    @Column(nullable = true, updatable = false)
    private String createdBy;

    @Column(nullable = true)
    @LastModifiedBy
    private String updatedBy;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "team_member", joinColumns = @JoinColumn(name = "team_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> userList = new HashSet<User>();

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "allot_group_badge", joinColumns = @JoinColumn(name = "team_id"), inverseJoinColumns = @JoinColumn(name = "badge_id"))
    private Set<Badge> badgeSet = new HashSet<Badge>();

    public void addUser(User user) {
        userList.add(user);
    }

    public void removeUser(User user) {
        userList.remove(user);
    }

    public void addBadge(Badge badge) {
        badgeSet.add(badge);
    }

    public void removeBadge(Badge badge) {
        badgeSet.remove(badge);
    }
}