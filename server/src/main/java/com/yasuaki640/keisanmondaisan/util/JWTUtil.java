package com.yasuaki640.keisanmondaisan.util;

import com.yasuaki640.keisanmondaisan.service.impl.UserServiceImpl;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class JWTUtil {

    private static String secret;

    private static final long TOKEN_VAILD_DURATION = 1000L * 60L * 60L;

    private final UserServiceImpl service;

    public JWTUtil(UserServiceImpl service,
                   @Value("${app.jwt-token-secret:example-secret}") String secret
    ) {
        this.service = service;
        this.secret = secret;
    }

    public String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000L * 60L * 60L))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }
}
