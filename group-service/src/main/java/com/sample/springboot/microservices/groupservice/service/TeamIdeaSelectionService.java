package com.sample.springboot.microservices.groupservice.service;

import com.sample.springboot.microservices.common.code.entity.TeamIdeaSelection;
import com.sample.springboot.microservices.common.code.entity.TeamIdeas;
import com.sample.springboot.microservices.common.code.exception.CustomException;
import com.sample.springboot.microservices.common.code.exception.ResourceNotFoundException;

import org.springframework.stereotype.Service;

/**
 * Team idea selection service
 * @author Manjunath Asundi
 */
@Service
public interface TeamIdeaSelectionService {
    TeamIdeas updateTeamIdeaSelection(Long teamIdeasId,TeamIdeaSelection teamIdeaSelection)
            throws ResourceNotFoundException, CustomException;
}