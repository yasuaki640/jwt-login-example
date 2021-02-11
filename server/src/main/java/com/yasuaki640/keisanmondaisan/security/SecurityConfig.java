package com.yasuaki640.keisanmondaisan.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()

                // users
                .authorizeRequests()
                .mvcMatchers(HttpMethod.PUT, "/users/**")
                .authenticated()
                .mvcMatchers(HttpMethod.DELETE, "/users/**")
                .authenticated()
                .and()

                // login
                .formLogin()
                .loginProcessingUrl("/login")
                .permitAll()
                .usernameParameter("loginId")
                .passwordParameter("pass");

    }
}
