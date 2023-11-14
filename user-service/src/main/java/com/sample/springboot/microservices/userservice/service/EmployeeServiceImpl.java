package com.sample.springboot.microservices.userservice.service;

import java.util.List;

import com.sample.springboot.microservices.common.code.entity.Corporate;
import com.sample.springboot.microservices.common.code.entity.CorporateDomain;
import com.sample.springboot.microservices.common.code.entity.Role;
import com.sample.springboot.microservices.common.code.entity.User;
import com.sample.springboot.microservices.common.code.entity.constant.UserRole;
import com.sample.springboot.microservices.common.code.exception.CustomException;
import com.sample.springboot.microservices.common.code.exception.ResourceNotFoundException;
import com.sample.springboot.microservices.userservice.repository.CorporateRepository;
import com.sample.springboot.microservices.userservice.repository.RoleRepository;
import com.sample.springboot.microservices.userservice.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * Employee service implementaion
 * 
 * @author Manjunath Asundi
 */
@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CorporateRepository corporateRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User addEmployee(User user) throws CustomException {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));

            Corporate corporate = corporateRepository.findById(user.getCorporate().getId())
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "Corporate doesn't exist with id:" + user.getCorporate().getId()));

            corporate.addEmployee(user);
            user.setCorporate(corporate);

            List<CorporateDomain> corporateDomainList = corporate.getCorporateDomainList();

            String email = user.getEmail();
            String emailDomain = email.substring(email.indexOf("@") + 1, email.length());

            boolean isDomainExists = corporateDomainList.stream()
                    .anyMatch((corporateDomain) -> corporateDomain.getName().equalsIgnoreCase(emailDomain));
            if (!isDomainExists)
                throw new CustomException("Invalid email, you should use professional emailId");

            UserRole userRole = UserRole.EMPLOYEE;
            Role role = roleRepository.findByName(userRole);
            role.addUser(user);
            user.setRole(role);
            return userRepository.save(user);
        } catch (Exception e) {
            log.error("Exception->{}", e.getMessage());
            throw new CustomException(e.getMessage());
        }
    }

}