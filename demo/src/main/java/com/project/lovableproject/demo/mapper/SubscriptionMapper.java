package com.project.lovableproject.demo.mapper;

import com.project.lovableproject.demo.dto.subscription.PlanResponse;
import com.project.lovableproject.demo.dto.subscription.SubscriptionResponse;
import com.project.lovableproject.demo.entity.Plan;
import com.project.lovableproject.demo.entity.Subscription;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubscriptionMapper {

    SubscriptionResponse toSubscriptionResponse(Subscription subscription);

    PlanResponse toPlanResponse(Plan plan);
}
