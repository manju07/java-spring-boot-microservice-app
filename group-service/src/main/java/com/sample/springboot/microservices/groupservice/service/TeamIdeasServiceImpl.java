package com.sample.springboot.microservices.groupservice.service;

import java.util.List;

import com.sample.springboot.microservices.common.code.entity.Team;
import com.sample.springboot.microservices.common.code.entity.TeamIdeaSelection;
import com.sample.springboot.microservices.common.code.entity.TeamIdeas;
import com.sample.springboot.microservices.common.code.entity.TeamVirtualWallIdeas;
import com.sample.springboot.microservices.common.code.exception.CustomException;
import com.sample.springboot.microservices.common.code.exception.ResourceNotFoundException;
import com.sample.springboot.microservices.groupservice.repository.TeamIdeaSelectionRepository;
import com.sample.springboot.microservices.groupservice.repository.TeamIdeasRepository;
import com.sample.springboot.microservices.groupservice.repository.TeamRepository;
import com.sample.springboot.microservices.groupservice.repository.TeamVirtualIdeaRepository;
import com.sample.springboot.microservices.groupservice.util.UserData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * Team idea servie implementation
 * 
 * @author Manjunath Asundi
 */
@Service
@Slf4j
public class TeamIdeasServiceImpl implements TeamIdeasService {

    @Autowired
    private TeamIdeasRepository teamIdeasRepository;

    @Autowired
    private TeamVirtualIdeaRepository teamVirtualIdeaRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private TeamIdeaSelectionRepository teamIdeaSelectionRepository;

    @Override
    public TeamIdeas addIdea(TeamIdeas teamIdeas, Long teamId, Long ideaId)
            throws ResourceNotFoundException, CustomException {
        try {
            String userName = UserData.getUserName();
            Team team = teamRepository.findById(teamId)
                    .orElseThrow(() -> new ResourceNotFoundException("Team doesn't exists with id:" + teamId));
            TeamVirtualWallIdeas idea = teamVirtualIdeaRepository.findById(ideaId)
                    .orElseThrow(() -> new ResourceNotFoundException("Idea doesn't exists with id:" + ideaId));
            teamIdeas.setTeam(team);
            teamIdeas.setTeamVirtualWallIdeas(idea);
            teamIdeas.setCreatedBy(userName);
            teamIdeas.setUpdatedBy(userName);

            TeamIdeaSelection teamIdeaSelection = new TeamIdeaSelection();
            teamIdeaSelection.setIdeate(false);
            teamIdeaSelection.setProjectIdentification(false);
            teamIdeaSelection.setPrototypePhase(false);
            teamIdeaSelection.setTestPhase(false);
            teamIdeaSelection.setCreatedBy(userName);
            teamIdeaSelection.setUpdatedBy(userName);
            TeamIdeaSelection returnTeamIdeaSelection = teamIdeaSelectionRepository.save(teamIdeaSelection);
            teamIdeas.setTeamIdeaSelection(returnTeamIdeaSelection);

            return teamIdeasRepository.save(teamIdeas);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public TeamIdeas updateIdea(TeamIdeas teamIdeas, Long teamId, Long ideaId)
            throws ResourceNotFoundException, CustomException {
        try {
            String userName = UserData.getUserName();
            TeamIdeas savedTeamIdeas = teamIdeasRepository.findById(teamIdeas.getId()).orElseThrow(
                    () -> new ResourceNotFoundException("TeamIdea does not exist with id:" + teamIdeas.getId()));
            Team team = teamRepository.findById(teamId)
                    .orElseThrow(() -> new ResourceNotFoundException("Team doesn't exists with id:" + teamId));
            TeamVirtualWallIdeas idea = teamVirtualIdeaRepository.findById(ideaId)
                    .orElseThrow(() -> new ResourceNotFoundException("Idea doesn't exists with id:" + ideaId));
            savedTeamIdeas.setTeam(team);
            savedTeamIdeas.setTeamVirtualWallIdeas(idea);
            savedTeamIdeas.setIdeate(teamIdeas.getIdeate());
            savedTeamIdeas.setPrototypePhase(teamIdeas.getPrototypePhase());
            savedTeamIdeas.setTestPhase(teamIdeas.getTestPhase());
            savedTeamIdeas.setUpdatedBy(userName);
            return teamIdeasRepository.save(savedTeamIdeas);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public List<TeamIdeas> getAllTeamIdeas() throws CustomException {
        try {
            return teamIdeasRepository.findAll();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }
}