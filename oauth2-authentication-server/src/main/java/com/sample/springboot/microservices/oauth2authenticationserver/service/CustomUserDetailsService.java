package com.sample.springboot.microservices.oauth2authenticationserver.service;

import java.util.Optional;

import com.sample.springboot.microservices.common.code.entity.User;
import com.sample.springboot.microservices.oauth2authenticationserver.entity.CustomUserDetails;
import com.sample.springboot.microservices.oauth2authenticationserver.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * CustomUserDetailsService
 * @author Manjunath Asundi
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> usersOptional = usersRepository.findByUserName(username);

        usersOptional
                .orElseThrow(() -> new UsernameNotFoundException("Username not found!"));
        return usersOptional
                .map(CustomUserDetails::new)
                .get();
    }
}