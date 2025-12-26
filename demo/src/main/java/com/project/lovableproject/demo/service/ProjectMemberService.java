package com.project.lovableproject.demo.service;

import com.project.lovableproject.demo.dto.member.InviteMemberRequest;
import com.project.lovableproject.demo.dto.member.MemberResponse;
import com.project.lovableproject.demo.entity.ProjectMember;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface ProjectMemberService {

     List<ProjectMember> getProjectMembers(Long projectId, Long userId);

     MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId);

     MemberResponse updateMemberRole(Long projectId, Long memberId, InviteMemberRequest request, Long userId);

     MemberResponse deleteProjectMember(Long projectId, Long memberId, Long userId);
}
