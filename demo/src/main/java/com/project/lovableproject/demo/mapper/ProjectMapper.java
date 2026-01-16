package com.project.lovableproject.demo.mapper;

import com.project.lovableproject.demo.dto.project.ProjectResponse;
import com.project.lovableproject.demo.entity.Project;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    ProjectResponse toProjectResponse(Project project);
}
