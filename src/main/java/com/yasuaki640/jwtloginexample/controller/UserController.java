package com.yasuaki640.jwtloginexample.controller;

import com.yasuaki640.jwtloginexample.model.SiteUser;
import com.yasuaki640.jwtloginexample.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserDetailsServiceImpl service;

    @Autowired
    public UserController(UserDetailsServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/user")
    public ResponseEntity<SiteUser> registerUser(@RequestBody SiteUser user) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.createUser(user));
    }

}
