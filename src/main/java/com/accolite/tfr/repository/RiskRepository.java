package com.accolite.tfr.repository;

import com.accolite.tfr.model.ProjectStatus;
import com.accolite.tfr.model.Risk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RiskRepository extends JpaRepository<Risk,Integer> {
    @Query(value="SELECT * FROM risk where project_id=?1",nativeQuery=true)
    List<Risk> findRiskByProjectId(int p_id);
//    List<Risk> findRiskByProjectId(int p_id);
}
