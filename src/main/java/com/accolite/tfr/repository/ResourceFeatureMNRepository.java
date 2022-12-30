package com.accolite.tfr.repository;

import com.accolite.tfr.model.Resource;
import com.accolite.tfr.model.ResourceFeatureMN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ResourceFeatureMNRepository extends JpaRepository<ResourceFeatureMN, Integer> {
    @Query(value="select feature_id from resource_feature_mn_resource r join resource_feature_mn_feature f where r.resource_id=?1 and r.resource_featuremn_id = f.resource_featuremn_id ",nativeQuery=true)
    List<ResourceFeatureMN> findResourceByResourceId(int r_id);
}
