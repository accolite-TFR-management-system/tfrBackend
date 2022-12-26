package com.accolite.tfr.repository;

import com.accolite.tfr.model.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Clients,Integer> {
}
