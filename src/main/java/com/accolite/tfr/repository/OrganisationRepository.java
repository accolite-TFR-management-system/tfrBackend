package com.accolite.tfr.repository;

import com.accolite.tfr.model.Organisation;
import com.accolite.tfr.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrganisationRepository extends JpaRepository<Organisation,Integer> {
    @Query(value="select * from organization r where r.parent_id=0 and grandparent_id=0",nativeQuery=true)
    List<Organisation> findAllDivsions();

    @Query(value="select * from organization r where r.parent_id!=0 and grandparent_id=0",nativeQuery=true)
    List<Organisation> findAllSupDep();
}
