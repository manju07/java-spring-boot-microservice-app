package com.sample.springboot.microservices.userservice.repository;

import java.util.List;
import java.util.Optional;


import com.sample.springboot.microservices.common.code.entity.Corporate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
/**
 * @author Manjunath Asundi
 */
@Repository
public interface CorporateRepository extends JpaRepository<Corporate, Long> {

    List<Corporate> findByName(String name);
    
    List<Corporate> findByClientSpocPhone(String clientSpocPhone);

    List<Corporate> findByClientSpocEmail(String clientSpocEmail);

    Optional<Corporate> findByIdAndCreatedBy(Long corporateId, String createdBy);

    List<Corporate> findByCreatedBy(String createdBy);

    List<Corporate> findByCreatedByAndIsDeleted(String createdBy, Boolean isDeleted);

    @Query(value = "select * from corporate  where is_deleted=1", nativeQuery = true)
    List<Corporate> getAllArchivedCorporates();
}