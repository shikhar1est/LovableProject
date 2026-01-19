package com.project.lovableproject.demo.repository;

import com.project.lovableproject.demo.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepositoy extends JpaRepository<Project,Long> {
    @Query("""
            SELECT p FROM Project p
            WHERE p.deletedAt IS NULL
            AND p.owner.id = :userId
            ORDER BY p.updatedAt DESC
            """)
          List<Project> findAllAccessibleByUser(@Param("userId") long userId);
}
