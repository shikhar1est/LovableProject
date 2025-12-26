package com.project.lovableproject.demo.service;

import com.project.lovableproject.demo.dto.subscription.CheckoutRequest;
import com.project.lovableproject.demo.dto.subscription.CheckoutResponse;
import com.project.lovableproject.demo.dto.subscription.PortalResponse;
import com.project.lovableproject.demo.dto.subscription.SubscriptionResponse;
import org.jspecify.annotations.Nullable;

public interface SubscriptionService {
     SubscriptionResponse getCurrentSubscription();

    CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request, Long userId);

     PortalResponse openCustomerPortal(Long userId);
}
