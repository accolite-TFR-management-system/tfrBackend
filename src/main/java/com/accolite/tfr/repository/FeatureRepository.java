package com.accolite.tfr.repository;

import com.accolite.tfr.entity.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureRepository extends JpaRepository<Feature,Integer> {
    @Query(value="select * from feature r where r.id=?1",nativeQuery=true)
    Feature findFeatureById(int featureId);
}
