package com.example.student_management_system.controller;

import com.example.student_management_system.model.User;
import com.example.student_management_system.repository.UserRepository;
import com.example.student_management_system.dto.RegisterRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.example.student_management_system.dto.LoginRequest;
import com.example.student_management_system.util.JwtUtil;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    //inject dependencies
    @Autowired
    private UserRepository repo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody RegisterRequest request) {

        User user = new User();
        user.setUsername(request.getUsername());
        //encrypt password
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        // force safe default role
        user.setRole("ROLE_USER");

        repo.save(user);

        return Map.of("message", "User registered successfully!");
    }

@PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginRequest request) {

        User user = repo.findByUsername(request.getUsername());

        if (user == null) {
            return Map.of("error", "User not found!");
        }

        boolean matches = passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        );

    if (!matches) {
            return Map.of("error", "Invalid password!");
        }

        String token = JwtUtil.generateToken(user.getUsername());

        return Map.of("token", token);
    }
}



