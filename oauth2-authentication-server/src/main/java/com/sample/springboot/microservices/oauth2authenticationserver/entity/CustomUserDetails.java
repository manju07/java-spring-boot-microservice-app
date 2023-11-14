package com.sample.springboot.microservices.oauth2authenticationserver.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sample.springboot.microservices.common.code.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * CustomUserDetails
 * @author Manjunath Asundi
 */
public class CustomUserDetails extends User implements UserDetails {

    private static final long serialVersionUID = -7579108809034777577L;

    public CustomUserDetails(final User user) {
        super(user);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> roleList = new ArrayList<SimpleGrantedAuthority>();
        roleList.add(new SimpleGrantedAuthority("ROLE_" + this.getRole().getName()));
        return roleList;
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
