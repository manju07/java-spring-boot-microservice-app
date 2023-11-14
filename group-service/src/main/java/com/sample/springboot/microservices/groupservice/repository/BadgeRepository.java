package com.sample.springboot.microservices.groupservice.repository;

import com.sample.springboot.microservices.common.code.entity.Badge;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Badge repository
 * @author Manjunath Asundi
 */
@Repository
public interface BadgeRepository extends JpaRepository<Badge, Long> {
    
}