package com.yasuaki640.keisanmondaisan.util;

import com.yasuaki640.keisanmondaisan.model.User;
import com.yasuaki640.keisanmondaisan.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = JWTUtil.class)
public class JWTUtilTests {

    private JWTUtil util;

    @MockBean
    private UserServiceImpl service;

    @BeforeEach
    void setup() {
        this.util = new JWTUtil(service, "test secret key");
    }

    @Test
    void test_createToken() {
        User user = User.builder().id(1L)
                .loginId("yasu")
                .password("pass")
                .build();

        Map<String, Object> claims = new HashMap<>();
        claims.put("loginId", "yasu");

        String generated = util.createToken(claims, String.valueOf(user.getId()))
                .split("\\.")[0];
        String expected = "eyJhbGciOiJIUzI1NiJ9";

        assertEquals(expected, generated);
    }
}
