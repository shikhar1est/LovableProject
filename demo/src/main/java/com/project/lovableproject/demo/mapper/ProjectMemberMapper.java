package com.project.lovableproject.demo.mapper;

import com.project.lovableproject.demo.dto.member.MemberResponse;
import com.project.lovableproject.demo.entity.ProjectMember;
import com.project.lovableproject.demo.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectMemberMapper {
    MemberResponse toProjectMemberResponseFromOwner(User owner);
    MemberResponse toProjectMemberResponseFromMember(ProjectMember projectMember);
}
