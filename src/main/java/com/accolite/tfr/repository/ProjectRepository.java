package com.accolite.tfr.repository;

import com.accolite.tfr.model.Project;
import com.accolite.tfr.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,Integer> {
    @Query(value="SELECT * FROM project where id=?1",nativeQuery=true)
    Project findProjectById(int p_id);
}
