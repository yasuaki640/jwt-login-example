package com.yasuaki640.jwtloginexample.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yasuaki640.jwtloginexample.model.AuthenticationRequest;
import com.yasuaki640.jwtloginexample.model.SiteUser;
import com.yasuaki640.jwtloginexample.repository.SiteUserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
public class AuthenticateControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SiteUserRepository repository;

    private SiteUser testUser = SiteUser.of("yasu", "pass");

    @BeforeEach
    void setUp() {
        repository.save(testUser);
    }

    @AfterEach
    void tearDown() {
        repository.deleteAll();
    }

    @Test
    void test_authenticateSuccess() throws Exception {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest(
                testUser.getUsername(), testUser.getPassword());
        String requestJson = objectMapper.writeValueAsString(authenticationRequest);

        RequestBuilder builder = MockMvcRequestBuilders
                .post("/authenticate")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson);

        mockMvc.perform(builder)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$.jwt").isNotEmpty());
    }

    @Test
    void test_authenticateFailure_wrongPassword() throws Exception {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest(
                testUser.getUsername(), testUser.getPassword() + "is wrong");
        String requestJson = objectMapper.writeValueAsString(authenticationRequest);

        RequestBuilder builder = MockMvcRequestBuilders
                .post("/authenticate")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson);

        mockMvc.perform(builder)
                .andExpect(status().isForbidden());
    }

    @Test
    void test_authenticateFailure_wrongUsername() throws Exception {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest(
                testUser.getUsername() + "is wrong", testUser.getPassword());
        String requestJson = objectMapper.writeValueAsString(authenticationRequest);

        RequestBuilder builder = MockMvcRequestBuilders
                .post("/authenticate")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson);

        mockMvc.perform(builder)
                .andExpect(status().isForbidden());
    }
}
