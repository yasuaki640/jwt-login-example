package com.yasuaki640.keisanmondaisan.util;

import com.yasuaki640.keisanmondaisan.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JWTUtil {

    @Value("${app.jwt-token-secret:UTC}")
    private static String TOKEN_SECRET_KEY;

    private static final long TOKEN_VAILD_DURATION = 1000L * 60L * 60L;

    private final UserServiceImpl service;

    public JWTUtil(UserServiceImpl service) {
        this.service = service;
    }
}
