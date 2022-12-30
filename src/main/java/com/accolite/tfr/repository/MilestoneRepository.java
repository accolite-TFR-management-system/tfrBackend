package com.accolite.tfr.repository;

import com.accolite.tfr.model.Milestone;
import com.accolite.tfr.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MilestoneRepository extends JpaRepository<Milestone,Integer> {
    @Query(value="SELECT * FROM milestone where project_id=?1",nativeQuery=true)
    List<Milestone> findMilestoneByPId(int p_id);
}
