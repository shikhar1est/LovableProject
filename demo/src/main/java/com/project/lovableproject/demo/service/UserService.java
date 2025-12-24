package com.project.lovableproject.demo.service;

import com.project.lovableproject.demo.dto.auth.UserProfileResponse;
import org.jspecify.annotations.Nullable;

public interface UserService {
    UserProfileResponse getProfile(Long userId);
}
