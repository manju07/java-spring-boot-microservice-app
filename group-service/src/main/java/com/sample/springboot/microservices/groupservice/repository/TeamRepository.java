package com.sample.springboot.microservices.groupservice.repository;

import com.sample.springboot.microservices.common.code.entity.Team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * @author Manjunath Asundi
 */
@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

}