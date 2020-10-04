package com.sample.springboot.microservices.oauth2authenticationserver.repository;

import com.sample.springboot.microservices.oauth2authenticationserver.entity.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Role Repository
 * @author Manjunath Asundi
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    
}