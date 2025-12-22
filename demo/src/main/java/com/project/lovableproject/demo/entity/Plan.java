package com.project.lovableproject.demo.entity;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Plan {
    Long id;
    String name;
    String stripeProjectId;
    Integer maxProjects;
    Integer maxTokensPerDay;
    Integer maxPreviews; //limited previews are allowed as they consume resources
    Boolean unlimitedAI;
    Boolean active;
}
