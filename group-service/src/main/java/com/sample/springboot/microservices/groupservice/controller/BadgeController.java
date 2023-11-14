package com.sample.springboot.microservices.groupservice.controller;

import com.sample.springboot.microservices.common.code.dto.TeamBadgeDto;
import com.sample.springboot.microservices.common.code.dto.UserBadgeDto;
import com.sample.springboot.microservices.common.code.entity.Team;
import com.sample.springboot.microservices.common.code.entity.User;
import com.sample.springboot.microservices.common.code.exception.CustomException;
import com.sample.springboot.microservices.common.code.exception.ResourceNotFoundException;
import com.sample.springboot.microservices.groupservice.service.BadgeService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * badge api's
 * 
 * @author Manjunath Asundi
 */
@CrossOrigin(origins = "*")
@RestController
@Api(value = "Sample-App", description = "Admin or Manager dealing associating badges to the team and user")
@Slf4j
public class BadgeController {

    @Autowired
    private BadgeService badgeService;

    @Autowired
    private ModelMapper modelMapper;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MANAGER')")
    @PutMapping(value = "/add-badge/team/{teamId}/badge/{badgeId}", produces = "application/json")
    @ApiOperation(value = "Assign badge to the team", response = TeamBadgeDto.class)
    public ResponseEntity<TeamBadgeDto> addBadgeToTeam(@PathVariable("teamId") Long teamId,
            @PathVariable("badgeId") Long badgeId) throws ResourceNotFoundException, CustomException {
        log.info("calling add badge to team REST api");
        Team team = badgeService.addBadgeToTeam(teamId, badgeId);
        TeamBadgeDto returnTeamBadgeDto = modelMapper.map(team, TeamBadgeDto.class);
        return new ResponseEntity<TeamBadgeDto>(returnTeamBadgeDto, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MANAGER')")
    @PutMapping(value = "/add-badge/user/{userId}/badge/{badgeId}", produces = "application/json")
    @ApiOperation(value = "Assign badge to the user", response = UserBadgeDto.class)
    public ResponseEntity<UserBadgeDto> addBadgeToUser(@PathVariable("userId") Long userId,
            @PathVariable("badgeId") Long badgeId) throws ResourceNotFoundException, CustomException {
        log.info("calling add badge to user REST api");
        User user = badgeService.addBadgeToUser(userId, badgeId);
        UserBadgeDto returnUserBadgeDto = modelMapper.map(user, UserBadgeDto.class);
        return new ResponseEntity<UserBadgeDto>(returnUserBadgeDto, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MANAGER')")
    @DeleteMapping(value = "/remove-badge/team/{teamId}/badge/{badgeId}")
    @ApiOperation(value = "Remove badge to the team", response = TeamBadgeDto.class)
    public ResponseEntity<TeamBadgeDto> removeBadgeFromTeam(@PathVariable("teamId") Long teamId,
            @PathVariable("badgeId") Long badgeId) throws ResourceNotFoundException, CustomException {
        log.info("calling remove badge to team REST api");
        Team team = badgeService.removeBadgeFromTeam(teamId, badgeId);
        TeamBadgeDto teamBadgeDto = modelMapper.map(team, TeamBadgeDto.class);
        return new ResponseEntity<TeamBadgeDto>(teamBadgeDto, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MANAGER')")
    @DeleteMapping(value = "/remove-badge/user/{userId}/badge/{badgeId}")
    @ApiOperation(value = "Remove badge to the user", response = UserBadgeDto.class)
    public ResponseEntity<UserBadgeDto> removeBadgeFromUser(@PathVariable("userId") Long userId,
            @PathVariable("badgeId") Long badgeId) throws ResourceNotFoundException, CustomException {
        log.info("calling remove badge to user REST api");
        User returnUser = badgeService.removeBadgeFromUser(userId, badgeId);
        UserBadgeDto returnUserBadgeDto = modelMapper.map(returnUser, UserBadgeDto.class);
        return new ResponseEntity<UserBadgeDto>(returnUserBadgeDto, HttpStatus.OK);
    }
}