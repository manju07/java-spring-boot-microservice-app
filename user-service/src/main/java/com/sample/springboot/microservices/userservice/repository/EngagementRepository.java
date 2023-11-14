package com.sample.springboot.microservices.userservice.repository;

import java.util.List;


import com.sample.springboot.microservices.common.code.entity.Corporate;
import com.sample.springboot.microservices.common.code.entity.Engagement;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * EngagementRepository
 * @author Manjunath Asundi
 */
@Repository
public interface EngagementRepository extends CrudRepository<Engagement, Long> {
    List<Engagement> findByCorporate(Corporate corporate);
    
    @Query(value = "select * from engagement  where is_deleted=1", nativeQuery = true)
    List<Engagement> getAllArchivedEngagements();
}