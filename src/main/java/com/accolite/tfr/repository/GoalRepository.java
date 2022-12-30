package com.accolite.tfr.repository;

import com.accolite.tfr.model.Goals;
import com.accolite.tfr.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GoalRepository extends JpaRepository<Goals,Integer> {
    @Query(value="select * from goals r where r.milestone_id=?1",nativeQuery=true)
    List<Goals> findResourceByMilestoneId(int mile_id);
}
