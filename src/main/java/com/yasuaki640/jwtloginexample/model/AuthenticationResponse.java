package com.yasuaki640.jwtloginexample.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AuthenticationResponse {

    private final String jwt;
}
