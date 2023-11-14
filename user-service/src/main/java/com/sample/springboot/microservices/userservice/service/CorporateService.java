package com.sample.springboot.microservices.userservice.service;

import java.util.List;

import com.sample.springboot.microservices.common.code.entity.Corporate;
import com.sample.springboot.microservices.common.code.exception.ResourceNotFoundException;
import com.sample.springboot.microservices.common.code.exception.CustomException;

/**
 * @author Manjunath Asundi
 */
public interface CorporateService {
    Corporate addCorporate(Corporate corporate) throws ResourceNotFoundException, CustomException;

    Corporate updateCorporate(Long corporateId, Corporate corporate) throws ResourceNotFoundException, CustomException;

    Boolean deleteCorporateById(Long corporateId) throws ResourceNotFoundException, CustomException;

    Corporate getCorporateById(Long corporateId) throws ResourceNotFoundException, CustomException;

    List<Corporate> getCorporateList() throws CustomException;

    List<Corporate> getArchiveCorporateList() throws CustomException;
}