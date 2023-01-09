package com.accolite.tfr.repository;

import com.accolite.tfr.DTOmodel.OrganisationModel;
import com.accolite.tfr.model.Organisation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrganisationRepository extends JpaRepository<Organisation,Integer> {
	@Query(value="SELECT * from organization o where o.department_type=?1",nativeQuery=true)
	List<Organisation> FindbyDepartment_type(String div);
	@Query(value="SELECT * from organization o where o.department_type=?1",nativeQuery=true)
	List<Organisation> Findbysuperdept(String div);
	@Query(value="SELECT * from organization o where o.department_type=?1",nativeQuery=true)
	List<Organisation> Findbydept(String div);
}
