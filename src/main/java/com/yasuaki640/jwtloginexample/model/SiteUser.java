package com.yasuaki640.jwtloginexample.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SiteUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 2, max = 20)
    private String username;

    @NotBlank
    @Size(min = 4, max = 255)
    private String password;

    @Email
    private String email;

    private int gender;

    private boolean admin;

    private String role;

    @Builder.Default
    private boolean active = true;

    public static SiteUser of(String username, String password) {
        return SiteUser.builder().username(username).password(password).admin(false).build();
    }
}