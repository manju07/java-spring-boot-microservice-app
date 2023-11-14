package com.sample.springboot.microservices.oauth2authenticationserver.repository;

import java.util.Optional;

import com.sample.springboot.microservices.common.code.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * User Repository
 * @author Manjunath Asundi
 */
@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String username);
}