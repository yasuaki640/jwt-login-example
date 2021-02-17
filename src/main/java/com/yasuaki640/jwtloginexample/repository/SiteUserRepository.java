package com.yasuaki640.jwtloginexample.repository;

import com.yasuaki640.jwtloginexample.model.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteUserRepository extends JpaRepository<SiteUser,Long> {

    SiteUser findByUsername(String username);
}
