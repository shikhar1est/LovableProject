package com.project.lovableproject.demo.dto.member;

public record MemberResponse(
        Long userId,
        String email,
        String name,
        String avatarUrl
) {
}
