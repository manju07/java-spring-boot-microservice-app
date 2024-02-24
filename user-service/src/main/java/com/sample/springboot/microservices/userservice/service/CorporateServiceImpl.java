package com.sample.springboot.microservices.userservice.service;

import com.sample.springboot.microservices.common.code.entity.Corporate;
import com.sample.springboot.microservices.common.code.entity.CorporateDomain;
import com.sample.springboot.microservices.common.code.exception.CustomException;
import com.sample.springboot.microservices.common.code.exception.ResourceNotFoundException;
import com.sample.springboot.microservices.userservice.repository.CorporateRepository;
import com.sample.springboot.microservices.userservice.util.UserData;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

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
    @Transactional
    public Corporate addCorporate(Corporate corporate) throws ResourceNotFoundException, CustomException {
        try {

            validateUniqueValuesAlreadyExistInDB(corporate);

            // Corporate domains
            List<CorporateDomain> corporateDomains = corporate.getCorporateDomainList();
            if (Objects.nonNull(corporateDomains)) {
                corporateDomains.parallelStream().forEach(corporateDomain -> corporateDomain.setCorporate(corporate));
                corporate.setCorporateDomainList(corporateDomains);
            } else {
                throw new ResourceNotFoundException("Corporate domain list is emptt/null");
            }

            if (Objects.nonNull(corporate.getAddress())) {
                
                corporate.getAddress().setCorporate(corporate);
            }

            String userName = UserData.getUserName();
            corporate.setCreatedBy(userName);
            corporate.setUpdatedBy(userName);
            Corporate returnCorporate = corporateRepository.save(corporate);
            return returnCorporate;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    private void validateUniqueValuesAlreadyExistInDB(Corporate corporate) throws CustomException {
        if (Objects.nonNull(corporate)) {
            List<Corporate> corporateList = null;

            if (Objects.nonNull(corporate.getName())) {
                corporateList = corporateRepository.findByName(corporate.getName());
                validateList("name", corporate.getName(), corporateList);
            }

            if (Objects.nonNull(corporate.getClientSpocPhone())) {
                corporateList = corporateRepository.findByClientSpocPhone(corporate.getClientSpocPhone());
                validateList("clientSpocPhone", corporate.getClientSpocPhone(), corporateList);
            }

            if (Objects.nonNull(corporate.getClientSpocEmail())) {
                corporateList = corporateRepository.findByClientSpocEmail(corporate.getClientSpocEmail());
                validateList("clientSpocEmail", corporate.getClientSpocEmail(), corporateList);
            }
        }
    }

    private void validateList(String alreadyExistAttributeName, String alreadyExistAttribute,
            List<Corporate> corporateList) throws CustomException {
        if (!corporateList.isEmpty()) {
            throw new CustomException("Already exists", 403,
                    "Corporate already exists with " + alreadyExistAttributeName + ":" + alreadyExistAttribute);
        }
    }

    @Override
    @Transactional
    public Corporate updateCorporate(Long corporateId, Corporate corporate)
            throws ResourceNotFoundException, CustomException {
        try {

            Corporate savedCorporate = corporateRepository.findById(corporateId)
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
            
            if (corporateDomains != null && (!corporateDomains.isEmpty())) {

                corporateDomains.parallelStream().forEach(domain -> domain.setCorporate(corporate));
                savedCorporate.setCorporateDomainList(corporateDomains);
            }

            savedCorporate.setAddress(corporate.getAddress());
            corporate.getAddress().setCorporate(savedCorporate);
            savedCorporate.setUpdatedBy(UserData.getUserName());
            return corporateRepository.save(savedCorporate);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @Override
    @Transactional
    public Boolean deleteCorporateById(Long corporateId) throws ResourceNotFoundException, CustomException {
        try {
            String userName = UserData.getUserName();
            Corporate corporate = corporateRepository.findById(corporateId)
                    .orElseThrow(() -> new ResourceNotFoundException("Corporate doesn't exist with id:" + corporateId));
            corporate.setIsDeleted(true);
            corporate.setUpdatedBy(userName);
            corporateRepository.save(corporate);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public List<Corporate> getCorporateList() throws CustomException {
        try {
            return corporateRepository.findAll();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Corporate getCorporateById(Long corporateId) throws ResourceNotFoundException, CustomException {
        try {
            Corporate corporate = corporateRepository.findById(corporateId)
                    .orElseThrow(() -> new ResourceNotFoundException("Corporate doesn't exist with id:" + corporateId));
            return corporate;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public List<Corporate> getArchiveCorporateList() throws CustomException {
        try {
            return corporateRepository.getAllArchivedCorporates();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }
}