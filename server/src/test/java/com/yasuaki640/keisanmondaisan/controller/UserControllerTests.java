package com.yasuaki640.keisanmondaisan.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(value = UserController.class)
public class UserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void test_findAll() {
    }
}
