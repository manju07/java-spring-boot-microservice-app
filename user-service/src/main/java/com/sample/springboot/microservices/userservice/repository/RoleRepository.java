package com.sample.springboot.microservices.userservice.repository;

import com.sample.springboot.microservices.common.code.entity.Role;
import com.sample.springboot.microservices.common.code.entity.constant.UserRole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Manjunath Asundi
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(UserRole name);
}