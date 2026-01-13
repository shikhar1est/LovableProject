package com.project.lovableproject.demo.dto.subscription;

public record PlanLimitsResponse(
        String planName,
        Integer maxTokensPerDay,
        Integer maxProjects,
        boolean unlimitedAi
) {
}
