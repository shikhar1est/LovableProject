package com.project.lovableproject.demo.service.impl;

import com.project.lovableproject.demo.dto.subscription.PlanResponse;
import com.project.lovableproject.demo.service.PlanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {
    @Override
    public List<PlanResponse> getAllActivePlans() {
        return List.of();
    }
}
