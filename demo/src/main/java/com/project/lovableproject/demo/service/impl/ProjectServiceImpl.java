package com.project.lovableproject.demo.service.impl;

import com.project.lovableproject.demo.dto.project.ProjectRequest;
import com.project.lovableproject.demo.dto.project.ProjectResponse;
import com.project.lovableproject.demo.dto.project.ProjectSummaryResponse;
import com.project.lovableproject.demo.entity.Project;
import com.project.lovableproject.demo.entity.ProjectMember;
import com.project.lovableproject.demo.entity.ProjectMemberId;
import com.project.lovableproject.demo.entity.User;
import com.project.lovableproject.demo.enums.ProjectRole;
import com.project.lovableproject.demo.error.ResourceNotFoundException;
import com.project.lovableproject.demo.mapper.ProjectMapper;
import com.project.lovableproject.demo.repository.ProjectMemberRepository;
import com.project.lovableproject.demo.repository.ProjectRepositoy;
import com.project.lovableproject.demo.repository.UserRepository;
import com.project.lovableproject.demo.service.ProjectService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
@Transactional
public class ProjectServiceImpl implements ProjectService {
    ProjectRepositoy projectRepositoy;
    UserRepository userRepository;
    ProjectMapper projectMapper;
    ProjectMemberRepository projectMemberRepository;

    @Override
    public ProjectResponse createProject(ProjectRequest request, Long userId) {
        User owner=userRepository.findById(userId).orElseThrow();
        Project project=Project.builder()
                .name(request.name())
                .build();
        project=projectRepositoy.save(project);

        ProjectMemberId projectMemberId=new ProjectMemberId(project.getId(), owner.getId());
        ProjectMember projectMember = ProjectMember.builder()
                .id(projectMemberId)
                .projectRole(ProjectRole.OWNER)
                .user(owner)
                .acceptedAt(Instant.now())
                .invitedAt(Instant.now())
                .project(project)
                .build();

        projectMemberRepository.save(projectMember);
        return projectMapper.toProjectResponse(project);
    }
    @Override
    public List<ProjectSummaryResponse> getUserProjects(Long userId) {
//        return projectRepositoy.findAllAccessibleByUser(userId).
//                stream().
//                map(project -> projectMapper.toProjectSummaryResponse(project)).
//                collect(Collectors.toList());
        var projects=projectRepositoy.findAllAccessibleByUser(userId);
        return projectMapper.toListOfProjectSummaryResponse(projects);
    }

    @Override
    public ProjectResponse getUserProjectsById(Long id, Long userId) {
        Project project=getAccessibleProjectByUserId(id,userId);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request, Long userId) {
        Project project=getAccessibleProjectByUserId(id,userId);
        project.setName(request.name());
       project= projectRepositoy.save(project);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public void softDelete(Long id, Long userId) {
        Project project=getAccessibleProjectByUserId(id,userId);
        project.setDeletedAt(Instant.now());
        projectRepositoy.save(project);
    }

    //Internal function so as to DRY
    public Project getAccessibleProjectByUserId(Long projectId,Long userId){
        return projectRepositoy.findAccessibleProjectById(projectId,userId).orElseThrow(
                () -> new ResourceNotFoundException("Project", projectId.toString())
        );
    }
}
