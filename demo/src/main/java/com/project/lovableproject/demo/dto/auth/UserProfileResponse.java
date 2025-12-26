package com.project.lovableproject.demo.dto.auth;

import com.project.lovableproject.demo.enums.ProjectRole;

import java.time.Instant;

public record UserProfileResponse(
        Long userId,
        String email,
        String name,
        String avatarUrl,
        ProjectRole role,
        Instant invitedAt
) {
}
