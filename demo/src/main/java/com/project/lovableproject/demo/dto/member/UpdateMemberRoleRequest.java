package com.project.lovableproject.demo.dto.member;

import com.project.lovableproject.demo.enums.ProjectRole;
import jakarta.validation.constraints.NotNull;

public record UpdateMemberRoleRequest(@NotNull ProjectRole role) {
}
