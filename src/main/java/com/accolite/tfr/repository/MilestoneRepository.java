package com.accolite.tfr.repository;

import com.accolite.tfr.entity.Milestone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MilestoneRepository extends JpaRepository<Milestone,Integer> {
    @Query(value="select * from milestone m where m.project_id=?1",nativeQuery=true)
    List<Milestone> findMilestoneByProjectId(int pro_id);
}
