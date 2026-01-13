package com.project.lovableproject.demo.service.impl;

import com.project.lovableproject.demo.dto.project.ProjectRequest;
import com.project.lovableproject.demo.dto.project.ProjectResponse;
import com.project.lovableproject.demo.dto.project.ProjectSummaryResponse;
import com.project.lovableproject.demo.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Override
    public List<ProjectSummaryResponse> getUserProjects(Long userId) {
        return List.of();
    }

    @Override
    public ProjectResponse getUserProjectsById(Long id, Long userId) {
        return null;
    }

    @Override
    public ProjectResponse createProject(ProjectRequest request, Long userId) {
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
