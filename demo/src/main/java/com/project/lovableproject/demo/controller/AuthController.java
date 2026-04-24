package com.project.lovableproject.demo.controller;

import com.project.lovableproject.demo.dto.auth.AuthResponse;
import com.project.lovableproject.demo.dto.auth.LoginRequest;
import com.project.lovableproject.demo.dto.auth.SignupRequest;
import com.project.lovableproject.demo.dto.auth.UserProfileResponse;
import com.project.lovableproject.demo.entity.User;
import com.project.lovableproject.demo.error.BadRequestException;
import com.project.lovableproject.demo.mapper.UserMapper;
import com.project.lovableproject.demo.repository.UserRepository;
import com.project.lovableproject.demo.service.AuthService;
import com.project.lovableproject.demo.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
@RequestMapping("/api/auth")
public class AuthController {
    AuthService authService;
    UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signup(@RequestBody SignupRequest request) {
        return ResponseEntity.ok(authService.signup(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> getProfile(){
        Long userId=1L;
        return ResponseEntity.ok(userService.getProfile(userId));
    }
}
