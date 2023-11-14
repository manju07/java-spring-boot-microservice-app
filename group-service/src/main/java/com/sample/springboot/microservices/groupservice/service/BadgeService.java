package com.sample.springboot.microservices.groupservice.service;

import com.sample.springboot.microservices.common.code.entity.Team;
import com.sample.springboot.microservices.common.code.entity.User;
import com.sample.springboot.microservices.common.code.exception.CustomException;
import com.sample.springboot.microservices.common.code.exception.ResourceNotFoundException;

import org.springframework.stereotype.Service;
/**
 * Badge service
 * @author Manjunath Asundi
 */
@Service
public interface BadgeService {
    Team addBadgeToTeam(Long teamId,Long badgeId) throws ResourceNotFoundException, CustomException;
    User addBadgeToUser(Long userId,Long badgeId) throws ResourceNotFoundException, CustomException;
    Team removeBadgeFromTeam(Long teamId,Long badgeId) throws ResourceNotFoundException, CustomException;
    User removeBadgeFromUser(Long userId,Long badgeId) throws ResourceNotFoundException, CustomException;
}