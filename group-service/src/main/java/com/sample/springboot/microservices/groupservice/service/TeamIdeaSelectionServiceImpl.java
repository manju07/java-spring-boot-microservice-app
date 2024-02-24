package com.sample.springboot.microservices.groupservice.service;

import com.sample.springboot.microservices.common.code.entity.TeamIdeaSelection;
import com.sample.springboot.microservices.common.code.entity.TeamIdeas;
import com.sample.springboot.microservices.common.code.exception.CustomException;
import com.sample.springboot.microservices.common.code.exception.ResourceNotFoundException;
import com.sample.springboot.microservices.groupservice.repository.TeamIdeaSelectionRepository;
import com.sample.springboot.microservices.groupservice.repository.TeamIdeasRepository;
import com.sample.springboot.microservices.groupservice.util.UserData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * Team idea selection service implementation
 * 
 * @author Manjunath Asundi
 */
@Service
@Slf4j
public class TeamIdeaSelectionServiceImpl implements TeamIdeaSelectionService {

    @Autowired
    private TeamIdeaSelectionRepository teamIdeaSelectionRepository;

    @Autowired
    private TeamIdeasRepository teamIdeasRepository;

    @Override
    public TeamIdeas updateTeamIdeaSelection(Long teamIdeasId, TeamIdeaSelection teamIdeaSelection)
            throws ResourceNotFoundException, CustomException {
        try {
            String userName = UserData.getUserName();
            TeamIdeas teamIdea = teamIdeasRepository.findById(teamIdeasId)
                    .orElseThrow(() -> new ResourceNotFoundException("Team Idea doesn't exist with id:" + teamIdeasId));
            // teamIdeaSelection.set
            TeamIdeaSelection savedTeamIdeaSelection = teamIdeaSelectionRepository.findById(teamIdeaSelection.getId())
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "TeamIdeaSelection does not exists with id:" + teamIdeaSelection.getId()));
            savedTeamIdeaSelection.setIdeate(teamIdeaSelection.getIdeate());
            savedTeamIdeaSelection.setPrototypePhase(teamIdeaSelection.getPrototypePhase());
            savedTeamIdeaSelection.setProjectIdentification(teamIdeaSelection.getProjectIdentification());
            savedTeamIdeaSelection.setTestPhase(teamIdeaSelection.getTestPhase());
            savedTeamIdeaSelection.setUpdatedBy(userName);
            TeamIdeaSelection returnTeamIdeaSelection = teamIdeaSelectionRepository.save(savedTeamIdeaSelection);

            teamIdea.setTeamIdeaSelection(returnTeamIdeaSelection);
            TeamIdeas returnTeamIdea = teamIdeasRepository.save(teamIdea);
            return returnTeamIdea;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }
}