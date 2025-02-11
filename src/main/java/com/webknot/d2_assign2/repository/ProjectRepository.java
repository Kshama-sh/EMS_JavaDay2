package com.webknot.d2_assign2.repository;

import com.webknot.d2_assign2.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
