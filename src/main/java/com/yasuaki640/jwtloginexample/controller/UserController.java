package com.yasuaki640.jwtloginexample.controller;

import com.yasuaki640.jwtloginexample.model.SiteUser;
import com.yasuaki640.jwtloginexample.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserDetailsServiceImpl service;

    public static final String PASSWORD_MASK = "not display";

    @Autowired
    public UserController(UserDetailsServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SiteUser> registerUser(@RequestBody SiteUser user) {
        SiteUser responseUser = service.createUser(user);
        responseUser.setPassword(PASSWORD_MASK);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SiteUser> getUserById(@PathVariable(value = "id") Long id) {
        Optional<SiteUser> user = service.findById(id);
        user.ifPresent((u) -> u.setPassword(PASSWORD_MASK));

        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


}
