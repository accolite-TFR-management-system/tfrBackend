package com.accolite.tfr.repository;

import com.accolite.tfr.model.Goals;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalRepository extends JpaRepository<Goals,Integer> {
}
