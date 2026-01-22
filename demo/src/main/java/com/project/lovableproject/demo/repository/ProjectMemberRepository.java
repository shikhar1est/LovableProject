package com.project.lovableproject.demo.repository;

import com.project.lovableproject.demo.entity.ProjectMember;
import com.project.lovableproject.demo.entity.ProjectMemberId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectMemberRepository extends JpaRepository<ProjectMember, ProjectMemberId> {
}
