package com.accolite.tfr.repository;

import com.accolite.tfr.model.Project;
import com.accolite.tfr.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,Integer> {
    @Query(value="SELECT * FROM project where id=?1",nativeQuery=true)
    Project findProjectById(int p_id);

    @Query(value="select * FROM project where division_id=?1 or super_department_id=?1 or department_id=?1",nativeQuery = true)
    List<Project> findByOrgId(int o_id);
    @Query(value="SELECT * FROM project where client_id=?1",nativeQuery=true)
    List<Project> findAllByClientId(int c_id);
}
