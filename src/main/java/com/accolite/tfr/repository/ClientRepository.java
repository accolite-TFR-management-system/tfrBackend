package com.accolite.tfr.repository;

import com.accolite.tfr.entity.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientRepository extends JpaRepository<Clients,Integer> {
    @Query(value="SELECT * FROM clients where id=?1",nativeQuery=true)
    Clients findClientsById(int p_id);
}
