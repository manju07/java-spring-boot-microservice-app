package com.sample.springboot.microservices.common.code.repository;


import com.sample.springboot.microservices.common.code.entity.CheckpointReviewer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * check point review repository
 * @author Manjunath Asundi
 */
@Repository
public interface CheckpointReviewerRepository extends JpaRepository<CheckpointReviewer, Long> {
    
}