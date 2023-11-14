package com.sample.springboot.microservices.groupservice.controller;

import com.sample.springboot.microservices.common.code.dto.TeamIdeasSelectionDto;
import com.sample.springboot.microservices.common.code.entity.TeamIdeaSelection;
import com.sample.springboot.microservices.common.code.entity.TeamIdeas;
import com.sample.springboot.microservices.common.code.exception.CustomException;
import com.sample.springboot.microservices.common.code.exception.ResourceNotFoundException;
import com.sample.springboot.microservices.groupservice.service.TeamIdeaSelectionService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * Team idea selection REST api's
 * 
 * @author Manjunath Asundi
 */
@CrossOrigin(origins = "*")
@RestController
@Api(value = "Sample-App", description = "Team idea selection operations for Admin/Manager")
@Slf4j
public class TeamIdeaSelectionController {

    @Autowired
    private TeamIdeaSelectionService teamIdeaSelectionService;

    @Autowired
    private ModelMapper modelMapper;

    @PutMapping(value = "team-ideas/{teamIdeasId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN, ROLE_MANAGER')")
    @ApiOperation(value = "Update team idea selection", response = TeamIdeasSelectionDto.class, responseContainer = "List")
    public ResponseEntity<TeamIdeasSelectionDto> updateTeamIdeaSelection(@PathVariable("teamIdeasId") Long teamIdeasId,
            @RequestBody TeamIdeasSelectionDto teamIdeaSelectionDto) throws ResourceNotFoundException, CustomException {
        log.info("Update team idea selection api");
        TeamIdeaSelection teamIdeaSelection = modelMapper.map(teamIdeaSelectionDto, TeamIdeaSelection.class);
        TeamIdeas returnTeamIdeaSelection = teamIdeaSelectionService.updateTeamIdeaSelection(teamIdeasId,
                teamIdeaSelection);
        TeamIdeasSelectionDto returIdeasSelectionDto = modelMapper.map(returnTeamIdeaSelection.getTeamIdeaSelection(),
                TeamIdeasSelectionDto.class);
        return new ResponseEntity<TeamIdeasSelectionDto>(returIdeasSelectionDto, HttpStatus.OK);
    }
}