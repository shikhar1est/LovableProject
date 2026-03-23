package com.project.lovableproject.demo.dto.auth;

import com.project.lovableproject.demo.enums.ProjectRole;

import java.time.Instant;

public record UserProfileResponse(
        Long id,
        String username,
        String name
//url
) {
}
