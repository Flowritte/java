package com.es.ori.microservice.clientes.Service;

import com.es.ori.microservice.clientes.DTO.ClienteDTO;
import com.es.ori.microservice.clientes.Entities.Cliente;

import java.util.List;

public interface IClienteService {

    List<Cliente> findAll();
    Cliente save(ClienteDTO cliente);

    Cliente findById(Long id);

    void delete(Cliente cliente);

    boolean existsById(Long id);
}
