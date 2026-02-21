package com.project.lovableproject.demo.service.impl;

import com.project.lovableproject.demo.dto.member.InviteMemberRequest;
import com.project.lovableproject.demo.dto.member.MemberResponse;
import com.project.lovableproject.demo.dto.member.UpdateMemberRoleRequest;
import com.project.lovableproject.demo.entity.Project;
import com.project.lovableproject.demo.entity.ProjectMember;
import com.project.lovableproject.demo.entity.ProjectMemberId;
import com.project.lovableproject.demo.entity.User;
import com.project.lovableproject.demo.mapper.ProjectMemberMapper;
import com.project.lovableproject.demo.repository.ProjectMemberRepository;
import com.project.lovableproject.demo.repository.ProjectRepositoy;
import com.project.lovableproject.demo.repository.UserRepository;
import com.project.lovableproject.demo.service.ProjectMemberService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Transactional
public class ProjectMemberServiceImpl implements ProjectMemberService {
    ProjectMemberRepository projectMemberRepository;
    ProjectRepositoy projectRepositoy;
    ProjectMemberMapper projectMemberMapper;
    UserRepository userRepository;

    @Override
    public List<MemberResponse> getProjectMembers(Long projectId, Long userId) {
        return projectMemberRepository.findByIdProjectId(projectId)
                .stream()
                .map(projectMemberMapper::toProjectMemberResponseFromMember)
                .toList();
    }
    //comm

    @Override
    public MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId) {
        Project project=getAccessibleProjectByUserId(projectId,userId);
        if(!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("Not Allowed");
        }
        User invitee=userRepository.findByEmail(request.email()).orElseThrow();
        if(invitee.getId().equals(userId)){
            throw new RuntimeException("Cannot invite yourself");
        }
        ProjectMemberId projectMemberId=new ProjectMemberId(projectId,invitee.getId());
        if(projectMemberRepository.existsById(projectMemberId)){
            throw new RuntimeException("Cannot invite again");
        }
        ProjectMember member=ProjectMember.builder().
                id(projectMemberId)
                .project(project)
                .user(invitee)
                .projectRole(request.role())
                .invitedAt(Instant.now())
                .build();

        projectMemberRepository.save(member);
        return projectMemberMapper.toProjectMemberResponseFromMember(member);
    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request, Long userId) {
        Project project=getAccessibleProjectByUserId(projectId,userId);
        if(!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("Not Allowed");
        }
        ProjectMemberId projectMemberId=new ProjectMemberId(projectId,memberId);
        ProjectMember projectMember=projectMemberRepository.findById(projectMemberId).orElseThrow();
        projectMember.setProjectRole(request.role());
        projectMemberRepository.save(projectMember);
        return projectMemberMapper.toProjectMemberResponseFromMember(projectMember);
    }

    @Override
    public void removeProjectMember(Long projectId, Long memberId, Long userId) {
        Project project=getAccessibleProjectByUserId(projectId,userId);
        if(!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("Not Allowed");
        }
        ProjectMemberId projectMemberId=new ProjectMemberId(projectId,memberId);
        if(!projectMemberRepository.existsById(projectMemberId)){
            throw new RuntimeException("Member not found in project");
        }
        projectMemberRepository.deleteById(projectMemberId);
        return;
    }

    public Project getAccessibleProjectByUserId(Long id,Long userId){
        return projectRepositoy.findAccessibleProjectById(id,userId).orElseThrow();
    }
}
