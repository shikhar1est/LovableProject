package com.project.lovableproject.demo.service;

import com.project.lovableproject.demo.dto.subscription.PlanLimitsResponse;
import com.project.lovableproject.demo.dto.subscription.UsageTodayResponse;
import org.jspecify.annotations.Nullable;

public interface UsageService {
     UsageTodayResponse getTodayUsageOfUser(Long userId);

    PlanLimitsResponse getCurrentSubscriptionLimitsOfUser(Long userId);
}
//se