package com.sample.springboot.microservices.common.code.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.springboot.microservices.common.code.entity.CorporateDomain;

/**
 * Corporate domain repository
 * @author Manjunath Asundi
 */
@Repository
public interface CorporateDomainRepository extends JpaRepository<CorporateDomain, Long> {
    
}