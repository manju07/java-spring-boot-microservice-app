package com.sample.springboot.microservices.groupservice.controller;

import java.util.Arrays;
import java.util.List;

import com.sample.springboot.microservices.common.code.dto.TeamIdeasDto;
import com.sample.springboot.microservices.common.code.entity.TeamIdeas;
import com.sample.springboot.microservices.common.code.exception.CustomException;
import com.sample.springboot.microservices.common.code.exception.ResourceNotFoundException;
import com.sample.springboot.microservices.groupservice.service.TeamIdeasService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * Team ideation api's
 * 
 * @author Manjunath Asundi
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(produces = "application/json")
@Api(value = "Sample-App", description = "Team ideas operations")
@Slf4j
public class TeamIdeaController {

    @Autowired
    private TeamIdeasService teamIdeasService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("team-ideas/team/{teamId}/idea/{ideaId}")
    @PreAuthorize("hasAnyRole('ROLE_EMPLOYEE')")
    @ApiOperation(value = "submit idea", response = TeamIdeasDto.class)
    public ResponseEntity<TeamIdeasDto> submitIdea(@PathVariable("teamId") Long teamId,
            @PathVariable("ideaId") Long ideaId, @RequestBody TeamIdeasDto teamIdeasDto)
            throws CustomException, ResourceNotFoundException {
        log.info("calling submit idea api");
        TeamIdeas teamIdeas = modelMapper.map(teamIdeasDto, TeamIdeas.class);
        TeamIdeas returnTeamIdeas = teamIdeasService.addIdea(teamIdeas, teamId, ideaId);
        TeamIdeasDto returnTeamIdeasDto = modelMapper.map(returnTeamIdeas, TeamIdeasDto.class);
        return new ResponseEntity<TeamIdeasDto>(returnTeamIdeasDto, HttpStatus.OK);
    }

    @PutMapping("team-ideas/team/{teamId}/idea/{ideaId}")
    @PreAuthorize("hasAnyRole('ROLE_EMPLOYEE')")
    @ApiOperation(value = "update idea", response = TeamIdeasDto.class)
    public ResponseEntity<TeamIdeasDto> updateIdea(@PathVariable("teamId") Long teamId,
            @PathVariable("ideaId") Long ideaId, @RequestBody TeamIdeasDto teamIdeasDto)
            throws CustomException, ResourceNotFoundException {
        log.info("calling update idea api");
        TeamIdeas teamIdeas = modelMapper.map(teamIdeasDto, TeamIdeas.class);
        TeamIdeas returnTeamIdeas = teamIdeasService.updateIdea(teamIdeas, teamId, ideaId);
        TeamIdeasDto returnTeamIdeasDto = modelMapper.map(returnTeamIdeas, TeamIdeasDto.class);
        return new ResponseEntity<TeamIdeasDto>(returnTeamIdeasDto, HttpStatus.OK);
    }

    @GetMapping("/team-ideas")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN, ROLE_MANAGER, ROLE_EMPLOYEE')")
    @ApiOperation(value = "get all team ideas", response = TeamIdeasDto.class, responseContainer = "List")
    public ResponseEntity<List<TeamIdeasDto>> getAllTeamIdeas() throws CustomException, ResourceNotFoundException {
        log.info("calling get all team ideas api");
        List<TeamIdeas> teamIdeasList = teamIdeasService.getAllTeamIdeas();
        List<TeamIdeasDto> teamIdeasDtoList = Arrays.asList(modelMapper.map(teamIdeasList, TeamIdeasDto[].class));
        return new ResponseEntity<List<TeamIdeasDto>>(teamIdeasDtoList, HttpStatus.OK);
    }
}