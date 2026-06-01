package com.project.lovableproject.demo.service;

import com.project.lovableproject.demo.dto.project.ProjectRequest;
import com.project.lovableproject.demo.dto.project.ProjectResponse;
import com.project.lovableproject.demo.dto.project.ProjectSummaryResponse;

import java.util.List;

public interface ProjectService {
    List<ProjectSummaryResponse> getUserProjects();

    ProjectSummaryResponse getUserProjectById(Long id);

    ProjectResponse createProject(ProjectRequest request);

    ProjectResponse updateProject(Long id, ProjectRequest request);

    void softDelete(Long id);
}
