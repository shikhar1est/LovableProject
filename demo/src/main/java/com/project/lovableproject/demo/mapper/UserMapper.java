package com.project.lovableproject.demo.mapper;

import com.project.lovableproject.demo.dto.auth.SignupRequest;
import com.project.lovableproject.demo.dto.auth.UserProfileResponse;
import com.project.lovableproject.demo.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(SignupRequest signupRequest);
    UserProfileResponse toUserProfileResponse(User user);
}
