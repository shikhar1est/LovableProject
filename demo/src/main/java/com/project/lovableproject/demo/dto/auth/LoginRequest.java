package com.project.lovableproject.demo.dto.auth;

public record LoginRequest(
        String email,
        String password
) {
}
