package com.sample.springboot.microservices.groupservice.repository;

import com.sample.springboot.microservices.common.code.entity.TeamVirtualWallIdeas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Team Virtual idea repository
 * @author Manjunath Asundi
 */
@Repository
public interface TeamVirtualIdeaRepository extends JpaRepository<TeamVirtualWallIdeas, Long> {
    
}