package com.accolite.tfr.repository;

import com.accolite.tfr.model.ProjectStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectStatusRepository extends JpaRepository<ProjectStatus,Integer> {
}
