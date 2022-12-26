package com.accolite.tfr.repository;

import com.accolite.tfr.model.Milestone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MilestoneRepository extends JpaRepository<Milestone,Integer> {
}
