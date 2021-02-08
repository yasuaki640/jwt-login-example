package com.yasuaki640.keisanmondaisan.controller;

import com.yasuaki640.keisanmondaisan.model.AuthResult;
import com.yasuaki640.keisanmondaisan.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {

    @PostMapping
    @ResponseBody
    public ResponseEntity<AuthResult> authUser(@RequestBody User user, HttpServletResponse response) {
        Cookie cookie = new Cookie("session_id", "test id.");
        cookie.setMaxAge(265 * 24 * 60 * 60);
        cookie.setPath("/");

        response.addCookie(cookie);
        response.setStatus(HttpStatus.OK.value());

        return new ResponseEntity<>(new AuthResult(), HttpStatus.OK);
    }
}
