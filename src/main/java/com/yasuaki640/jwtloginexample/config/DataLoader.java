package com.yasuaki640.jwtloginexample.config;

import com.yasuaki640.jwtloginexample.model.SiteUser;
import com.yasuaki640.jwtloginexample.repository.SiteUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final SiteUserRepository repository;

    public DataLoader(SiteUserRepository repository){
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {

        repository.save(SiteUser.of("takoyaki","pass"));
        repository.save(SiteUser.of("yakisoba","pass"));
    }
}