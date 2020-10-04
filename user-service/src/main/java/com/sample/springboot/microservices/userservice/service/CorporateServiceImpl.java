package com.sample.springboot.microservices.userservice.service;

import java.util.List;

import com.sample.springboot.microservices.userservice.entity.Corporate;
import com.sample.springboot.microservices.userservice.entity.CorporateDomain;
import com.sample.springboot.microservices.userservice.exception.CustomException;
import com.sample.springboot.microservices.userservice.exception.ResourceNotFoundException;
import com.sample.springboot.microservices.userservice.repository.CorporateRepository;
import com.sample.springboot.microservices.userservice.util.UserData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * Corporate service implementation
 * 
 * @author Manjunath Asundi
 */
@Service
@Slf4j
public class CorporateServiceImpl implements CorporateService {

    @Autowired
    private CorporateRepository corporateRepository;

    @Override
    public Corporate addCorporate(Corporate corporate) throws ResourceNotFoundException, CustomException {
        try {
            String userName = UserData.getUserName();
            corporate.setCreatedBy(userName);
            corporate.setUpdatedBy(userName);

            // Corporate domains
            List<CorporateDomain> corporateDomains = corporate.getCorporateDomainList();
            for (CorporateDomain corporateDomain : corporateDomains) {
                corporateDomain.setCorporate(corporate);
            }
            corporate.setCorporateDomainList(corporateDomains);

            corporate.getAddress().setCorporate(corporate);
            Corporate returnCorporate = corporateRepository.save(corporate);
            return returnCorporate;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new CustomException(e.getMessage());
        }
    }

    @Override
    public Corporate updateCorporate(Long corporateId, Corporate corporate)
            throws ResourceNotFoundException, CustomException {
        try {
            String userName = UserData.getUserName();
            Corporate savedCorporate = corporateRepository.findByIdAndCreatedBy(corporateId, userName)
                    .orElseThrow(() -> new ResourceNotFoundException("Corporate doesn't exist with id:" + corporateId));

            if (!corporate.getName().isEmpty())
                savedCorporate.setName(corporate.getName());
            if (!corporate.getClientSpocName().isEmpty())
                savedCorporate.setClientSpocName(corporate.getClientSpocName());
            if (!corporate.getClientSpocPhone().isEmpty())
                savedCorporate.setClientSpocPhone(corporate.getClientSpocPhone());
            if (!corporate.getClientSpocEmail().isEmpty())
                savedCorporate.setClientSpocEmail(corporate.getClientSpocEmail());
            if (!corporate.getGst().isEmpty())
                savedCorporate.setGst(corporate.getGst());

            // corporate domains
            List<CorporateDomain> corporateDomains = corporate.getCorporateDomainList();
            if (corporateDomains != null && corporateDomains.size() != 0) {
                for (CorporateDomain corporateDomain : corporateDomains) {
                    corporateDomain.setCorporate(savedCorporate);
                }
                savedCorporate.setCorporateDomainList(corporateDomains);
            }

            savedCorporate.setAddress(corporate.getAddress());
            corporate.getAddress().setCorporate(savedCorporate);
            savedCorporate.setUpdatedBy(userName);
            return corporateRepository.save(savedCorporate);
        } catch (ResourceNotFoundException e) {
            log.error("ResourceNotFoundException->{}", e.getMessage());
            throw new ResourceNotFoundException(e.getMessage());
        } catch (Exception e) {
            log.error("Exception->{}", e.getMessage());
            throw new CustomException(e.getMessage());
        }
    }

    @Override
    public Boolean deleteCorporateById(Long corporateId) throws ResourceNotFoundException, CustomException {
        try {
            String userName = UserData.getUserName();
            Corporate corporate = corporateRepository.findById(corporateId)
                    .orElseThrow(() -> new ResourceNotFoundException("Corporate doesn't exist with id:" + corporateId));
            corporate.setIsDeleted(true);
            corporate.setUpdatedBy(userName);
            corporateRepository.save(corporate);
            return true;
        } catch (ResourceNotFoundException e) {
            log.error("ResourceNotFoundException->{}", e.getMessage());
            throw new ResourceNotFoundException(e.getMessage());
        } catch (Exception e) {
            log.error("Exception->{}", e.getMessage());
            throw new CustomException(e.getMessage());
        }

    }

    @Override
    public List<Corporate> getCorporateList() throws CustomException {
        try {
            return corporateRepository.findAll();
        } catch (Exception e) {
            log.error("Exception->{}", e.getMessage());
            throw new CustomException(e.getMessage());
        }
    }

    @Override
    public Corporate getCorporateById(Long corporateId) throws ResourceNotFoundException, CustomException {
        try {
            Corporate corporate = corporateRepository.findById(corporateId)
                    .orElseThrow(() -> new ResourceNotFoundException("Corporate doesn't exist with id:" + corporateId));
            return corporate;
        } catch (ResourceNotFoundException e) {
            log.error("ResourceNotFoundException->{}", e.getMessage());
            throw new ResourceNotFoundException(e.getMessage());
        } catch (Exception e) {
            log.error("Exception->{}", e.getMessage());
            throw new CustomException(e.getMessage());
        }
    }

    @Override
    public List<Corporate> getArchiveCorporateList() throws CustomException {
        try {
            return corporateRepository.getAllArchivedCorporates();
        } catch (Exception e) {
            log.error("Exception->{}", e.getMessage());
            throw new CustomException(e.getMessage());
        }
    }
}