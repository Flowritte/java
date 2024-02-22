package com.es.ori.microservice.clientes.Persistence;

import com.es.ori.microservice.clientes.Entities.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Cliente,Long> {

}
