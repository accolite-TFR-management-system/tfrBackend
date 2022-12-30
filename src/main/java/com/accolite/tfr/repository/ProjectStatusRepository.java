package com.accolite.tfr.repository;

import com.accolite.tfr.model.Project;
import com.accolite.tfr.model.ProjectStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectStatusRepository extends JpaRepository<ProjectStatus,Integer> {
    @Query(value="SELECT * FROM project_status where project_id=?1",nativeQuery=true)
    List<ProjectStatus> findProjectStatusByProjectId(int p_id);


}
