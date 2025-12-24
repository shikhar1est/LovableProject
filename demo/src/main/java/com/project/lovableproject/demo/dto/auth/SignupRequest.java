package com.project.lovableproject.demo.dto.auth;

public record SignupRequest(
        String email,
        String name,
        String password
) {
}
