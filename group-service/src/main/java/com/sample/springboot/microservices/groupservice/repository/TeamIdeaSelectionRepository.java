package com.sample.springboot.microservices.groupservice.repository;

import com.sample.springboot.microservices.common.code.entity.TeamIdeaSelection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Team idea selection repository
 * @author Manjunath Asundi
 */
@Repository
public interface TeamIdeaSelectionRepository extends JpaRepository<TeamIdeaSelection, Long> {
    
}