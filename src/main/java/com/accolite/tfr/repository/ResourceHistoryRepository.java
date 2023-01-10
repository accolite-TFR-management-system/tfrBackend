package com.accolite.tfr.repository;

import com.accolite.tfr.model.Project;
import com.accolite.tfr.model.ResourceHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ResourceHistoryRepository extends JpaRepository<ResourceHistory,Integer> {
    @Query(value="SELECT * FROM resource_history where resource_id=?1",nativeQuery=true)
    List<ResourceHistory> findResourceHistoryByResourceId(int r_id);

    @Query(value="SELECT * FROM resource_history where project_id=?1",nativeQuery=true)
    List<ResourceHistory> findResourceHistoryByProjectId(int p_id);

}
