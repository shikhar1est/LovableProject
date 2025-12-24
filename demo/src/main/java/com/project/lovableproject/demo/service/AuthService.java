package com.project.lovableproject.demo.service;

import com.project.lovableproject.demo.dto.auth.AuthResponse;
import com.project.lovableproject.demo.dto.auth.LoginRequest;
import com.project.lovableproject.demo.dto.auth.SignupRequest;
import org.jspecify.annotations.Nullable;

public interface AuthService {
     AuthResponse signup(SignupRequest request);
     AuthResponse login(LoginRequest request);
}
