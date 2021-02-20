package com.yasuaki640.jwtloginexample.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yasuaki640.jwtloginexample.model.SiteUser;
import com.yasuaki640.jwtloginexample.repository.SiteUserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
class UserControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SiteUserRepository repository;

    private SiteUser testUser = SiteUser.of("yasu", "pass");

    @BeforeEach
    void setUp() {
        repository.deleteAll();
        repository.save(testUser);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void test_registerUser() throws Exception {
        SiteUser user = SiteUser.of("aki", "pass");

        String requestJson = objectMapper.writeValueAsString(user);

        RequestBuilder builder = MockMvcRequestBuilders
                .post("/user")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson);

        mockMvc.perform(builder)
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$.username").value(user.getUsername()))
                .andExpect(jsonPath("$.password").value(UserController.PASSWORD_MASK));
    }

    @Test
    @WithMockUser(username = "yasu", password = "pass")
    void test_getById() throws Exception {
        RequestBuilder builder = MockMvcRequestBuilders
                .get("/user/{id}", testUser.getId())
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(builder)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$.username").value(testUser.getUsername()))
                .andExpect(jsonPath("$.password").value(UserController.PASSWORD_MASK));
    }

    @Test
    @WithMockUser(username = "yasu", password = "pass")
    void test_getById_notFound() throws Exception {
        RequestBuilder builder = MockMvcRequestBuilders
                .get("/user/{id}", testUser.getId() + 1L)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(builder)
                .andExpect(status().isNotFound());
    }

    @Test
    @WithMockUser(username = "yasu", password = "pass")
    void test_updateUser() throws Exception {
        SiteUser modiedTestUser = repository.findByUsername(testUser.getUsername());

        final String MOD_USERNAME = "modified";
        final String MOD_EMAIL = "tako@gmail.com";
        modiedTestUser.setUsername(MOD_USERNAME);
        modiedTestUser.setEmail(MOD_EMAIL);

        String requestJson = objectMapper.writeValueAsString(modiedTestUser);

        RequestBuilder builder = MockMvcRequestBuilders
                .put("/user")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson);

        mockMvc.perform(builder)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$.id").value(modiedTestUser.getId()))
                .andExpect(jsonPath("$.username").value(MOD_USERNAME))
                .andExpect(jsonPath("$.email").value(MOD_EMAIL));
    }
}