package com.sample.springboot.microservices.userservice.repository;

import com.sample.springboot.microservices.common.code.entity.Address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * AddressRepository
 * @author Manjunath Asundi
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}