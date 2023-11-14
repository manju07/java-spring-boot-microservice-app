package com.sample.springboot.microservices.userservice.repository;

import com.sample.springboot.microservices.common.code.entity.CorporateDomain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Corporate domain repository
 * @author Manjunath Asundi
 */
@Repository
public interface CorporateDomainRepository extends JpaRepository<CorporateDomain, Long> {
    
}