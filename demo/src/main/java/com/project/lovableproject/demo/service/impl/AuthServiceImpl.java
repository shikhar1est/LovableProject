package com.project.lovableproject.demo.service.impl;

import com.project.lovableproject.demo.dto.auth.AuthResponse;
import com.project.lovableproject.demo.dto.auth.LoginRequest;
import com.project.lovableproject.demo.dto.auth.SignupRequest;
import com.project.lovableproject.demo.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public AuthResponse signup(SignupRequest request) {
        return null;
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        return null;
    }
}
