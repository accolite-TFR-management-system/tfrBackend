package com.accolite.tfr.repository;

import com.accolite.tfr.model.Designation;
import com.accolite.tfr.model.Organisation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DesignationRepository extends JpaRepository<Designation,Integer> {
	@Query(value="SELECT id,designation_code,designation_name from designation",nativeQuery=true)
	List<Designation> Findall();
}
