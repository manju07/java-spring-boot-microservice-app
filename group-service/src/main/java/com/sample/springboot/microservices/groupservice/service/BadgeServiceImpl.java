package com.sample.springboot.microservices.groupservice.service;

import com.sample.springboot.microservices.common.code.entity.Badge;
import com.sample.springboot.microservices.common.code.entity.Team;
import com.sample.springboot.microservices.common.code.entity.User;
import com.sample.springboot.microservices.common.code.exception.CustomException;
import com.sample.springboot.microservices.common.code.exception.ResourceNotFoundException;
import com.sample.springboot.microservices.groupservice.repository.BadgeRepository;
import com.sample.springboot.microservices.groupservice.repository.TeamRepository;
import com.sample.springboot.microservices.groupservice.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * badge service implementation
 * 
 * @author Manjunath Asundi
 */
@Service
@Slf4j
public class BadgeServiceImpl implements BadgeService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private BadgeRepository badgeRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Team addBadgeToTeam(Long teamId, Long badgeId) throws ResourceNotFoundException, CustomException {
        try {
            Badge badge = badgeRepository.findById(badgeId)
                    .orElseThrow(() -> new ResourceNotFoundException("Badge doesn't exist with id:" + badgeId));
            Team team = teamRepository.findById(teamId)
                    .orElseThrow(() -> new ResourceNotFoundException("Team doesn't exist with id:" + teamId));
            team.addBadge(badge);
            return teamRepository.save(team);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public User addBadgeToUser(Long userId, Long badgeId) throws ResourceNotFoundException, CustomException {
        try {
            Badge badge = badgeRepository.findById(badgeId)
                    .orElseThrow(() -> new ResourceNotFoundException("Badge doesn't exist with id:" + badgeId));
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new ResourceNotFoundException("User doesn't exist with id:" + userId));
            user.addBadge(badge);
            return userRepository.save(user);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Team removeBadgeFromTeam(Long teamId, Long badgeId) throws ResourceNotFoundException, CustomException {
        try {
            Badge badge = badgeRepository.findById(badgeId)
                    .orElseThrow(() -> new ResourceNotFoundException("Badge doesn't exist with id:" + badgeId));
            Team team = teamRepository.findById(teamId)
                    .orElseThrow(() -> new ResourceNotFoundException("Team doesn't exist with id:" + teamId));
            team.removeBadge(badge);
            return teamRepository.save(team);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public User removeBadgeFromUser(Long userId, Long badgeId) throws ResourceNotFoundException, CustomException {
        try {
            Badge badge = badgeRepository.findById(badgeId)
                    .orElseThrow(() -> new ResourceNotFoundException("Badge doesn't exist with id:" + badgeId));
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new ResourceNotFoundException("User doesn't exist with id:" + userId));
            user.removeBadge(badge);
            return userRepository.save(user);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }
}