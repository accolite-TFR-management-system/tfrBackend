package com.accolite.tfr.repository;

import com.accolite.tfr.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ResourceRepository extends JpaRepository<Resource,Integer> {
    @Query(value="select * from resources r where r.designation_id=?1",nativeQuery=true)
    List<Resource> findResourceByDesignationId(int desg_id);
}
