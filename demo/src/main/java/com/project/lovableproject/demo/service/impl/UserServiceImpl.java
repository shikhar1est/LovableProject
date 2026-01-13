package com.project.lovableproject.demo.service.impl;

import com.project.lovableproject.demo.dto.auth.UserProfileResponse;
import com.project.lovableproject.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserProfileResponse getProfile(Long userId) {
        return null;
    }
}
