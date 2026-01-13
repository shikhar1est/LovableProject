package com.project.lovableproject.demo.service.impl;

import com.project.lovableproject.demo.dto.subscription.PlanLimitsResponse;
import com.project.lovableproject.demo.dto.subscription.UsageTodayResponse;
import com.project.lovableproject.demo.service.UsageService;
import org.springframework.stereotype.Service;

@Service
public class UsageServiceImpl implements UsageService {
    @Override
    public UsageTodayResponse getTodayUsageOfUser(Long userId) {
        return null;
    }

    @Override
    public PlanLimitsResponse getCurrentSubscriptionLimitsOfUser(Long userId) {
        return null;
    }
}
