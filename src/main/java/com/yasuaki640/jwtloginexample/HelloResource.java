package com.yasuaki640.jwtloginexample;

import com.yasuaki640.jwtloginexample.model.AuthenticationRequest;
import com.yasuaki640.jwtloginexample.model.AuthenticationResponse;
import com.yasuaki640.jwtloginexample.service.MyUserDetailsService;
import com.yasuaki640.jwtloginexample.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloResource {

    private final AuthenticationManager authenticationManager;

    private final MyUserDetailsService userDetailsService;

    private final JwtUtil jwtTokenUtil;

    @Autowired
    public HelloResource(AuthenticationManager authenticationManager, MyUserDetailsService userDetailsService, JwtUtil jwtTokenUtil) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!!";
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );

        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or pasword", e);
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
