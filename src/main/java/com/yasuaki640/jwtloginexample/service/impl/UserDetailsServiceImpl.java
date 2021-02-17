package com.yasuaki640.jwtloginexample.service.impl;

import com.yasuaki640.jwtloginexample.model.SiteUser;
import com.yasuaki640.jwtloginexample.repository.SiteUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    SiteUserRepository repository;

    @Autowired
    public UserDetailsServiceImpl(SiteUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return createUserDetails(SiteUser.builder()
                .username("yasu").password("pass")
                .build());
    }

    private UserDetails createUserDetails(SiteUser user) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }

}
