package com.github.nohgo.controllers;

import com.github.nohgo.requests.AuthRequest;
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
    public ResponseEntity<String> register(@RequestBody AuthRequest request) {
        if (request.getUsername() == null || request.getPassword() == null) {
            return ResponseEntity.badRequest().body("Username and password are required");
        }
        try {
            authService.register(request.getUsername(), request.getPassword());
            return ResponseEntity.ok("User registered successfully");
        } catch (Exception e) {}
        return ResponseEntity.badRequest().body("User registration failed");
    }

}
