package com.sample.springboot.microservices.common.code.repository;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sample.springboot.microservices.common.code.entity.User;

/**
 * @author Manjunath Asundi
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String userName);
    Optional<User> findByCreatedBy(String userName);
    Optional<User> findByIdAndCreatedBy(Long id, String username);
    
    @Query("select u from user u join u.role r where r.name='MANAGER'")
    List<User> getManagerList();

    @Query("select u from user u join u.role r where r.name='MANAGER' and u.id=?1")
    Optional<User> getManagerById(Long managerId);
    
    @Modifying
    @Query("update user u set u.fName = ?1, u.lName = ?2, u.gender = ?3, u.updatedBy = ?4 where u.id = ?5")
    void updateUser(String firstname, String lastname, String gender, String userName, Long userId);
}