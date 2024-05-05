package com.github.nohgo.controllers;

import com.github.nohgo.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody String username, String password) {
        try {
            authService.register(username, password);
            return ResponseEntity.ok("User registered successfully");
        } catch (Exception ignored) {}
        return ResponseEntity.badRequest().body("User registration failed");
    }

}
