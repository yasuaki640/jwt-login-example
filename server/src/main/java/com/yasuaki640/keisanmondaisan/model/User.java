package com.yasuaki640.keisanmondaisan.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    @Size(max = 256)
    private String loginId;

    @NotBlank
    private String password;

    @NotBlank
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    @OneToMany(targetEntity = AuthResultResponse.class)
    private List<AuthResultResponse> AuthResultResponses;
}
