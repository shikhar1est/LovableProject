package com.project.lovableproject.demo.mapper;

import com.project.lovableproject.demo.dto.project.ProjectResponse;
import com.project.lovableproject.demo.dto.project.ProjectSummaryResponse;
import com.project.lovableproject.demo.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    ProjectResponse toProjectResponse(Project project);
    @Mapping(source = "name", target = "projectName")
    ProjectSummaryResponse toProjectSummaryResponse(Project project);
    List<ProjectSummaryResponse> toListOfProjectSummaryResponse(List<Project> projects);
}
