package com.sample.springboot.microservices.groupservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.springboot.microservices.common.code.entity.Team;
import com.sample.springboot.microservices.common.code.entity.User;
import com.sample.springboot.microservices.common.code.exception.CustomException;
import com.sample.springboot.microservices.common.code.exception.ResourceNotFoundException;
import com.sample.springboot.microservices.groupservice.repository.TeamRepository;
import com.sample.springboot.microservices.groupservice.repository.UserRepository;
import com.sample.springboot.microservices.groupservice.util.UserData;

import lombok.extern.slf4j.Slf4j;

/**
 * Team service implementation
 * 
 * @author Manjunath Asundi
 */
@Slf4j
@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Team addTeam(Team team) throws CustomException {
        try {
            String userName = UserData.getUserName();
            team.setCreatedBy(userName);
            team.setUpdatedBy(userName);
            return teamRepository.save(team);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Team updateTeam(Long id, Team team) throws ResourceNotFoundException, CustomException {
        try {
            Team teamData = teamRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Team doesn't exist with id:" + id));
            String userName = UserData.getUserName();
            teamData.setUpdatedBy(userName);
            teamData.setName(team.getName());
            return teamRepository.save(teamData);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void archiveTeam(Long id) throws ResourceNotFoundException, CustomException {
        try {
            Team team = teamRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Team doesn't exist with id:" + id));
            String userName = UserData.getUserName();
            team.setIsDeleted(true);
            team.setUpdatedBy(userName);
            teamRepository.save(team);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public List<Team> getTeamList() throws ResourceNotFoundException, CustomException {
        List<Team> teamList = null;
        try {
            teamList = teamRepository.findAll();
            if (teamList.isEmpty()) {
                throw new ResourceNotFoundException("Team doesn't exist");
            }
            return teamList;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }

    }

    @Override
    public Team getTeamById(Long id) throws ResourceNotFoundException, CustomException {
        try {
            return teamRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Team doesn't exist with id:" + id));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Team addTeamMember(Long teamId, Long userId) throws ResourceNotFoundException, CustomException {
        try {
            Team team = teamRepository.findById(teamId)
                    .orElseThrow(() -> new ResourceNotFoundException("Team doesn't exist with id:" + teamId));
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new ResourceNotFoundException("User doesn't exist with id:" + userId));
            team.addUser(user);
            return teamRepository.save(team);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Team removeTeamMember(Long teamId, Long userId) throws ResourceNotFoundException, CustomException {
        try {
            Team team = teamRepository.findById(teamId)
                    .orElseThrow(() -> new ResourceNotFoundException("Team doesn't exist with id:" + teamId));
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new ResourceNotFoundException("User doesn't exist with id:" + userId));
            team.removeUser(user);
            return teamRepository.save(team);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }
}