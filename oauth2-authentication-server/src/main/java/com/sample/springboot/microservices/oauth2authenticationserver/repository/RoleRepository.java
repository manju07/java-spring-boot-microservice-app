package com.sample.springboot.microservices.oauth2authenticationserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.springboot.microservices.common.code.entity.Role;
/**
 * Role Repository
 * @author Manjunath Asundi
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    
}