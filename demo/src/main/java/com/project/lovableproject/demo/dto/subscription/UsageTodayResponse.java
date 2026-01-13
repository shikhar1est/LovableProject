package com.project.lovableproject.demo.dto.subscription;

public record UsageTodayResponse(
        Integer tokensUsed,
        Integer tokensLimit,
        Integer previewsRunning,
        Integer previewsList
) {
}
