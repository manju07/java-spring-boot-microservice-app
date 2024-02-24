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
import com.sample.springboot.microservices.userservice.util.UserData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * User service implementation
 * 
 * @author Manjunath Asundi
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CorporateRepository corporateRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User addUser(User user) throws ResourceNotFoundException, CustomException {
        try {
            String userName = UserData.getUserName();
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setIsEnabled(true);
            user.setCreatedBy(userName);
            user.setUpdatedBy(userName);

            Corporate corporate = corporateRepository.findById(user.getCorporate().getId())
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "Corporate doesn't exist with id:" + user.getCorporate().getId()));

            UserRole userRole = user.getRole().getName();

            if (!userRole.toString().equals("MANAGER") && !userRole.toString().equals("PARTNER"))
                throw new CustomException("You can create account for Manager/Partner only...!");

            List<CorporateDomain> corporateDomainList = corporate.getCorporateDomainList();

            String email = user.getEmail();
            String emailDomain = email.substring(email.indexOf("@") + 1, email.length());

            boolean isDomainExists = corporateDomainList.stream()
                    .anyMatch((corporateDomain) -> corporateDomain.getName().equalsIgnoreCase(emailDomain));

            if (!isDomainExists)
                throw new ResourceNotFoundException("Corporate domain doesn't exists");

            corporate.addEmployee(user);
            user.setCorporate(corporate);

            if (userRepository.findByPhone(user.getPhone()).isPresent())
                throw new CustomException("Phone already exist");

            Role role = roleRepository.findByName(userRole);
            role.addUser(user);
            user.setRole(role);
            return userRepository.save(user);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public User updateUser(Long userId, User user) throws ResourceNotFoundException, CustomException {
        try {
            String userName = UserData.getUserName();
            User userData = userRepository.findById(userId)
                    .orElseThrow(() -> new ResourceNotFoundException("User doesn't exist with id:" + userId));
            userData.setFName(user.getFName());
            userData.setLName(user.getLName());
            userData.setGender(user.getGender());

            Corporate corporate = corporateRepository.findById(user.getCorporate().getId())
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "Corporate doesn't exist with id:" + user.getCorporate().getId()));

            corporate.addEmployee(user);
            user.setCorporate(corporate);

            UserRole userRole = user.getRole().getName();
            if (!userRole.toString().equals("MANAGER") && !userRole.toString().equals("PARTNER"))
                throw new CustomException("You can update account for Manager/Partner only...!");
            else {
                Role role = roleRepository.findByName(userRole);
                role.addUser(userData);
                userData.setRole(role);
            }
            userData.setUpdatedBy(userName);
            return userRepository.save(userData);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }
}