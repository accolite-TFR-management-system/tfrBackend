package com.accolite.tfr.repository;

import com.accolite.tfr.model.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganisationRepository extends JpaRepository<Organisation,Integer> {
}
