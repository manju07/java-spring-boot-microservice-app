package com.sample.springboot.microservices.groupservice.repository;

import com.sample.springboot.microservices.common.code.entity.TeamIdeas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Team idease repository
 * @author Manjunath Asundi
 */
@Repository
public interface TeamIdeasRepository extends JpaRepository<TeamIdeas, Long> {

}