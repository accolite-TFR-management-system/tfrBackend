package com.accolite.tfr.repository;

import com.accolite.tfr.DTOmodel.OrganisationModel;
import com.accolite.tfr.model.Organisation;
import com.accolite.tfr.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrganisationRepository extends JpaRepository<Organisation,Integer> {
    @Query(value="select * from organization r where r.parent_id=0 and grandparent_id=0",nativeQuery=true)
    List<Organisation> findAllDivsions();

    @Query(value="select * from organization r where r.parent_id!=0 and grandparent_id=0",nativeQuery=true)
    List<Organisation> findAllSupDep();

    @Query(value="select * from organization r where id=?1",nativeQuery = true)
    Optional<Organisation> findByOrgId(int o_id);
    @Query(value="SELECT * from organization o where o.department_type=?1",nativeQuery=true)
	List<Organisation> FindbyDepartment_type(String div);
	@Query(value="SELECT * from organization o where o.department_type=?1",nativeQuery=true)
	List<Organisation> Findbysuperdept(String div);
	@Query(value="SELECT * from organization o where o.department_type=?1",nativeQuery=true)
	List<Organisation> Findbydept(String div);

}
