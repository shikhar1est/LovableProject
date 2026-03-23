package com.project.lovableproject.demo.dto.member;

import com.project.lovableproject.demo.enums.ProjectRole;

import java.time.Instant;

public record MemberResponse(
        Long userId,
        String username,
        String name,
        ProjectRole projectRole,
        Instant invitedAt
) {
}
