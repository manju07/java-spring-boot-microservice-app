package com.sample.springboot.microservices.groupservice.service;

import java.util.List;

import com.sample.springboot.microservices.groupservice.entity.TeamIdeas;
import com.sample.springboot.microservices.groupservice.exception.CustomException;
import com.sample.springboot.microservices.groupservice.exception.ResourceNotFoundException;

import org.springframework.stereotype.Service;

/**
 * @author Manjunath Asundi
 */
@Service
public interface TeamIdeasService {
    TeamIdeas addIdea(TeamIdeas teamIdeas, Long teamId, Long ideaId) throws ResourceNotFoundException, CustomException;
    TeamIdeas updateIdea(TeamIdeas teamIdeas, Long teamId, Long ideaId) throws ResourceNotFoundException, CustomException;
    List<TeamIdeas> getAllTeamIdeas() throws CustomException;
}