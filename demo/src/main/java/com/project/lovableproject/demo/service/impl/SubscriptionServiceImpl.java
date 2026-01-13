package com.project.lovableproject.demo.service.impl;

import com.project.lovableproject.demo.dto.subscription.CheckoutRequest;
import com.project.lovableproject.demo.dto.subscription.CheckoutResponse;
import com.project.lovableproject.demo.dto.subscription.PortalResponse;
import com.project.lovableproject.demo.dto.subscription.SubscriptionResponse;
import com.project.lovableproject.demo.service.SubscriptionService;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Override
    public SubscriptionResponse getCurrentSubscription() {
        return null;
    }

    @Override
    public CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request, Long userId) {
        return null;
    }

    @Override
    public PortalResponse openCustomerPortal(Long userId) {
        return null;
    }
}
