package com.yasuaki640.jwtloginexample.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class AuthenticationResponse {

    private final String jwt;
}
