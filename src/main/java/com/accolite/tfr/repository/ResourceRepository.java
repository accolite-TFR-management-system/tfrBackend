package com.accolite.tfr.repository;

import com.accolite.tfr.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ResourceRepository extends JpaRepository<Resource,Integer> {
    @Query(value="select * from resources r where r.designation_id=?1",nativeQuery=true)
    List<Resource> findResourceByDesignationId(int desg_id);
    @Query(value="select * from resources r where r.id=?1",nativeQuery=true)
    Resource findResourceById(int r_id);
    Resource findByEmail(String email);
    Resource findByEmail(String email);

}
