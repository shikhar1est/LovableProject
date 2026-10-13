package com.project.lovableproject.demo.controller;

import com.project.lovableproject.demo.dto.subscription.*;
import com.project.lovableproject.demo.service.PlanService;
import com.project.lovableproject.demo.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BillingController {
    private final PlanService planService;
    private final SubscriptionService subscriptionService;

    @GetMapping("/api/plans")
    public ResponseEntity<List<PlanResponse>> getAllPlans(){
        return ResponseEntity.ok(planService.getAllActivePlans());
    }

    @GetMapping("/api/me/subscription")
    public ResponseEntity<SubscriptionResponse> getMySubscription(){
        Long userId=1L;
        return ResponseEntity.ok(subscriptionService.getCurrentSubscription());
    }

    @PostMapping("/api/payments/checkout")
    public ResponseEntity<CheckoutResponse> createCheckoutResponse(
            @RequestBody CheckoutRequest request
            ){
        return ResponseEntity.ok(subscriptionService.createCheckoutSessionUrl(request));
    }

    @PostMapping("api/payments/portal")
    public ResponseEntity<PortalResponse> openCustomerPortal(){
        Long userId=1L;
        return ResponseEntity.ok(subscriptionService.openCustomerPortal(userId));
    }
}
