package com.project.lovableproject.demo.repository;

import com.project.lovableproject.demo.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepositoy extends JpaRepository<Project,Long> {

}
