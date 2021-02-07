package com.yasuaki640.keisanmondaisan.controller;

import com.yasuaki640.keisanmondaisan.model.AuthResultResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {

    @PostMapping
    public AuthResultResponse authUser(HttpServletRequest request) {
        log.info(request.toString());
        return new AuthResultResponse();
    }
}
