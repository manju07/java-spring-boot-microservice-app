package com.sample.springboot.microservices.userservice.repository;

import com.sample.springboot.microservices.common.code.entity.EngagementStatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Manjunath Asundi
 */
@Repository
public interface EngagementStatusRepository extends JpaRepository<EngagementStatus, Long> {
    
}