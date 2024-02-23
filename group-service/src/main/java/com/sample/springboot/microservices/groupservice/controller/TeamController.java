package com.sample.springboot.microservices.groupservice.controller;

import java.util.Arrays;
import java.util.List;

import com.sample.springboot.microservices.common.code.dto.TeamDto;
import com.sample.springboot.microservices.common.code.entity.Team;
import com.sample.springboot.microservices.common.code.exception.CustomException;
import com.sample.springboot.microservices.common.code.exception.ResourceNotFoundException;
import com.sample.springboot.microservices.common.code.model.TeamDeleteResponse;
import com.sample.springboot.microservices.common.code.model.TeamUserResponse;
import com.sample.springboot.microservices.groupservice.service.TeamService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * Team rest api's
 * 
 * @author Manjunath Asundi
 * 
 */
@CrossOrigin(origins = "*")
@RestController
@Slf4j
@Api(value = "Sample-App", description = "Admin or Manager dealing with Team/Group operations")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @Autowired
    private ModelMapper modelMapper;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MANAGER')")
    @PostMapping(value = "team", produces = "application/json")
    @ApiOperation(value = "Create a new team", response = TeamDto.class)
    public ResponseEntity<TeamDto> addNewTeam(@RequestBody TeamDto teamDto) throws CustomException {
        log.info("calling add new team api");
        Team team = modelMapper.map(teamDto, Team.class);
        Team returnTeam = teamService.addTeam(team);
        TeamDto returnTeamDto = modelMapper.map(returnTeam, TeamDto.class);
        return new ResponseEntity<TeamDto>(returnTeamDto, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MANAGER')")
    @PutMapping(value = "team/{teamId}", produces = "application/json")
    @ApiOperation(value = "Update team details", response = TeamDto.class)
    public ResponseEntity<TeamDto> updateTeam(@PathVariable("teamId") Long id, @RequestBody TeamDto teamDto)
            throws ResourceNotFoundException, CustomException {
        log.info("calling update team api");
        Team team = modelMapper.map(teamDto, Team.class);
        Team returnTeam = teamService.updateTeam(id, team);
        TeamDto returnTeamDto = modelMapper.map(returnTeam, TeamDto.class);
        return new ResponseEntity<TeamDto>(returnTeamDto, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MANAGER')")
    @DeleteMapping(value = "team/{teamId}", produces = "application/json")
    @ApiOperation(value = "Archive team by id", response = TeamDeleteResponse.class)
    public ResponseEntity<TeamDeleteResponse> archiveTeamById(@PathVariable("teamId") Long id)
            throws ResourceNotFoundException, CustomException {
        log.info("calling archive team by id api");
        teamService.archiveTeam(id);
        TeamDeleteResponse returnDeleteResponse = new TeamDeleteResponse();
        returnDeleteResponse.setId(id);
        returnDeleteResponse.setStatus("Team archived successfully");
        return new ResponseEntity<>(returnDeleteResponse, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MANAGER')")
    @GetMapping(value = "team/{teamId}", produces = "application/json")
    @ApiOperation(value = "Get team details by id", response = Team.class)
    public ResponseEntity<TeamDto> getTeamById(@PathVariable("teamId") Long id)
            throws CustomException, ResourceNotFoundException {
        log.info("calling get team details by id api");
        Team returnTeam = teamService.getTeamById(id);
        TeamDto returnTeamDto = modelMapper.map(returnTeam, TeamDto.class);
        return new ResponseEntity<TeamDto>(returnTeamDto, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MANAGER')")
    @GetMapping(value = "team", produces = "application/json")
    @ApiOperation(value = "Get team list", response = TeamDto.class, responseContainer = "List")
    public ResponseEntity<List<TeamDto>> getTeamList() throws ResourceNotFoundException, CustomException {
        log.info("calling get team list api");
        List<TeamDto> returnTeamDtoList = Arrays.asList(modelMapper.map(teamService.getTeamList(), TeamDto[].class));
        return new ResponseEntity<List<TeamDto>>(returnTeamDtoList, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MANAGER')")
    @PutMapping(value = "team/{teamId}/user/{userId}", produces = "application/json")
    @ApiOperation(value = "Add user to team", response = TeamUserResponse.class)
    public ResponseEntity<TeamUserResponse> addTeamMember(@PathVariable("teamId") Long teamId, @PathVariable("userId") Long userId)
            throws ResourceNotFoundException, CustomException {
        log.info("Calling user adding to team api");
        teamService.addTeamMember(teamId, userId);
        TeamUserResponse teamUserResponse = new TeamUserResponse();
        teamUserResponse.setTeamId(teamId);
        teamUserResponse.setUserId(userId);
        teamUserResponse.setStatus("User is added to the team");
        return new ResponseEntity<TeamUserResponse>(teamUserResponse, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MANAGER')")
    @DeleteMapping(value = "team/{teamId}/user/{userId}", produces = "application/json")
    @ApiOperation(value = "Remove user from team", response = TeamUserResponse.class)
    public ResponseEntity<TeamUserResponse> removeTeamMember(@PathVariable("teamId") Long teamId,
            @PathVariable("userId") Long userId) throws ResourceNotFoundException, CustomException {
        log.info("Calling user removing from team api");
        teamService.removeTeamMember(teamId, userId);
        TeamUserResponse teamUserResponse = new TeamUserResponse();
        teamUserResponse.setTeamId(teamId);
        teamUserResponse.setUserId(userId);
        teamUserResponse.setStatus("User is removed from the team");
        return new ResponseEntity<TeamUserResponse>(teamUserResponse, HttpStatus.OK);
    }
}