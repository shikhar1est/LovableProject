package com.project.lovableproject.demo.service.impl;

import com.project.lovableproject.demo.dto.auth.AuthResponse;
import com.project.lovableproject.demo.dto.auth.LoginRequest;
import com.project.lovableproject.demo.dto.auth.SignupRequest;
import com.project.lovableproject.demo.entity.User;
import com.project.lovableproject.demo.error.BadRequestException;
import com.project.lovableproject.demo.mapper.UserMapper;
import com.project.lovableproject.demo.repository.UserRepository;
import com.project.lovableproject.demo.service.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthServiceImpl implements AuthService {
    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse signup(SignupRequest request) {
        userRepository.findByUsername(request.username()).ifPresent(user -> {
            throw new BadRequestException("User already exists with username: "+request.username());
        });

        User user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.password()));
        user = userRepository.save(user);

        return new AuthResponse("dummy",userMapper.toUserProfileResponse(user));
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        return null;
    }
}
