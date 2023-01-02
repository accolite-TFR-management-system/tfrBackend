package com.accolite.tfr.repository;

import com.accolite.tfr.model.Clients;
import com.accolite.tfr.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientRepository extends JpaRepository<Clients,Integer> {
    @Query(value="select * from clients r where r.id=?1",nativeQuery=true)
    Clients findClientById(int clientId);
}
