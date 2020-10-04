package com.sample.springboot.microservices.groupservice.service;

import java.util.List;

import com.sample.springboot.microservices.groupservice.entity.Team;
import com.sample.springboot.microservices.groupservice.exception.CustomException;
import com.sample.springboot.microservices.groupservice.exception.ResourceNotFoundException;
/**
 * @author Manjunath Asundi
 */
public interface TeamService {
    Team addTeam(Team team) throws CustomException;

    Team updateTeam(Long id, Team team) throws ResourceNotFoundException, CustomException;

    void archiveTeam(Long id) throws ResourceNotFoundException, CustomException;

    List<Team> getTeamList() throws CustomException;

    Team getTeamById(Long id) throws ResourceNotFoundException, CustomException;
    
    Team addTeamMember(Long teamId, Long userId) throws ResourceNotFoundException, CustomException;

    Team removeTeamMember(Long teamId, Long userId) throws ResourceNotFoundException, CustomException;
}