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
        return createUserDetails(repository.findByUsername(username));
    }

    private UserDetails createUserDetails(SiteUser user) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }

    public SiteUser createUser(SiteUser user) {
        return repository.save(user);
    }

    public Optional<SiteUser> findById(Long id) {
        return repository.findById(id);
    }

    public void deleteUserById(Long id) {
        repository.deleteById(id);
    }
}
