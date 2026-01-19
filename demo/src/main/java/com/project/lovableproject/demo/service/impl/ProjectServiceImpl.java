package com.project.lovableproject.demo.service.impl;

import com.project.lovableproject.demo.dto.project.ProjectRequest;
import com.project.lovableproject.demo.dto.project.ProjectResponse;
import com.project.lovableproject.demo.dto.project.ProjectSummaryResponse;
import com.project.lovableproject.demo.entity.Project;
import com.project.lovableproject.demo.entity.User;
import com.project.lovableproject.demo.mapper.ProjectMapper;
import com.project.lovableproject.demo.repository.ProjectRepositoy;
import com.project.lovableproject.demo.repository.UserRepository;
import com.project.lovableproject.demo.service.ProjectService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

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

    @Override
    public ProjectResponse createProject(ProjectRequest request, Long userId) {
        User owner=userRepository.findById(userId).orElseThrow();
        Project project=Project.builder()
                .name(request.name())
                .owner(owner)
                .build();
        project=projectRepositoy.save(project);
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
        return null;
    }

    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request, Long userId) {
        return null;
    }

    @Override
    public void softDelete(Long id, Long userId) {

    }
}
