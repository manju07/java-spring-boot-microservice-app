package com.sample.springboot.microservices.userservice.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.sample.springboot.microservices.common.code.dto.CorporateDto;
import com.sample.springboot.microservices.common.code.entity.Corporate;
import com.sample.springboot.microservices.common.code.exception.CustomException;
import com.sample.springboot.microservices.common.code.exception.ResourceNotFoundException;
import com.sample.springboot.microservices.common.code.model.CorporateArchiveResponse;
import com.sample.springboot.microservices.userservice.service.CorporateService;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * Corporate api's
 * 
 * @author Manjunath Asundi
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/admin/corporate", produces = "application/json")
@PreAuthorize("hasRole('ROLE_ADMIN')")
@Api(value = "Sample-App", description = "Admin operations with corporates")
@Slf4j
public class CorporateController {

    @Autowired
    private CorporateService corporateService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ApiOperation(value = "Admin will create a corporate", response = CorporateDto.class)
    public ResponseEntity<CorporateDto> addCorporate(@Valid @RequestBody CorporateDto corporateDto)
            throws CustomException, ResourceNotFoundException {
        log.info("calling create corporate api");
        Corporate corporate = modelMapper.map(corporateDto, Corporate.class);
        Corporate returnCorporate = corporateService.addCorporate(corporate);
        CorporateDto returnCorporateDto = modelMapper.map(returnCorporate, CorporateDto.class);
        return new ResponseEntity<CorporateDto>(returnCorporateDto, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{corporateId}")
    @ApiOperation(value = "Get corporate details by id", response = CorporateDto.class)
    public ResponseEntity<CorporateDto> getCorporateById(@PathVariable("corporateId") Long corporateId)
            throws ResourceNotFoundException, CustomException {
        log.info("calling get corporate details by id api");
        Corporate returnCorporate = corporateService.getCorporateById(corporateId);
        CorporateDto returnCorporateDto = modelMapper.map(returnCorporate, CorporateDto.class);
        return new ResponseEntity<CorporateDto>(returnCorporateDto, HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation(value = "Get corporate list", response = CorporateDto.class, responseContainer = "List")
    public ResponseEntity<List<CorporateDto>> getCorporatesList() throws ResourceNotFoundException, CustomException {
        log.info("calling get corporate list api");
        List<Corporate> corporateList = corporateService.getCorporateList();
        List<CorporateDto> returnCorporateDtoList = new ArrayList<CorporateDto>();
        for (Corporate corporate : corporateList)
            returnCorporateDtoList.add(modelMapper.map(corporate, CorporateDto.class));
        return new ResponseEntity<List<CorporateDto>>(returnCorporateDtoList, HttpStatus.OK);
    }

    @PutMapping(value = "/{corporateId}")
    @ApiOperation(value = "Update corporate by id", response = CorporateDto.class)
    public ResponseEntity<CorporateDto> updateCorporateById(@PathVariable("corporateId") Long corporateId,
            @RequestBody CorporateDto corporatedDto) throws ResourceNotFoundException, CustomException {
        Corporate corporate = modelMapper.map(corporatedDto, Corporate.class);
        Corporate returnCorporate = corporateService.updateCorporate(corporateId, corporate);
        CorporateDto returnCorporateDto = modelMapper.map(returnCorporate, CorporateDto.class);
        return new ResponseEntity<CorporateDto>(returnCorporateDto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{corporateId}")
    @ApiOperation(value = "Archive corporate by id", response = CorporateArchiveResponse.class)
    public ResponseEntity<CorporateArchiveResponse> archiveCorporateById(@PathVariable("corporateId") Long corporateId)
            throws ResourceNotFoundException, CustomException {
        log.info("calling archive corporate api");
        corporateService.deleteCorporateById(corporateId);
        CorporateArchiveResponse corporateArchiveResponse = new CorporateArchiveResponse();
        corporateArchiveResponse.setId(corporateId);
        corporateArchiveResponse.setStatus("corporate archived successfully");
        return new ResponseEntity<CorporateArchiveResponse>(corporateArchiveResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/archive")
    @ApiOperation(value = "Get all archived corporate list", response = CorporateDto.class, responseContainer = "List")
    public ResponseEntity<List<CorporateDto>> getArchivedCorporateList()
            throws ResourceNotFoundException, CustomException {
        log.info("calling get all archived corporate list");
        List<Corporate> archivedCorporateList = corporateService.getArchiveCorporateList();
        List<CorporateDto> returnCorporateDtoList = new ArrayList<CorporateDto>();
        for (Corporate corporate : archivedCorporateList)
            returnCorporateDtoList.add(modelMapper.map(corporate, CorporateDto.class));
        return new ResponseEntity<List<CorporateDto>>(returnCorporateDtoList, HttpStatus.OK);
    }
}