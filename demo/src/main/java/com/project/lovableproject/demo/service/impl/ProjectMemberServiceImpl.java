package com.project.lovableproject.demo.service.impl;

import com.project.lovableproject.demo.dto.member.InviteMemberRequest;
import com.project.lovableproject.demo.dto.member.MemberResponse;
import com.project.lovableproject.demo.dto.member.UpdateMemberRoleRequest;
import com.project.lovableproject.demo.repository.ProjectMemberRepository;
import com.project.lovableproject.demo.repository.ProjectRepositoy;
import com.project.lovableproject.demo.service.ProjectMemberService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class ProjectMemberServiceImpl implements ProjectMemberService {
    ProjectMemberRepository projectMemberRepository;
    ProjectRepositoy projectRepositoy;
    @Override
    public List<MemberResponse> getProjectMembers(Long projectId, Long userId) {
        return List.of();
    }

    @Override
    public MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId) {
        return null;
    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request, Long userId) {
        return null;
    }

    @Override
    public MemberResponse deleteProjectMember(Long projectId, Long memberId, Long userId) {
        return null;
    }
}
