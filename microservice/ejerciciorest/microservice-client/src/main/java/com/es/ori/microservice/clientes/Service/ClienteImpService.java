package com.es.ori.microservice.clientes.Service;

import com.es.ori.microservice.clientes.DTO.ClienteDTO;
import com.es.ori.microservice.clientes.Entities.Cliente;
import com.es.ori.microservice.clientes.Persistence.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteImpService implements IClienteService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public List<Cliente> findAll(){

        return (List<Cliente>) clientRepository.findAll();
    }

    @Override
    @Transactional
    public Cliente save(ClienteDTO clientedto) {
        Cliente cliente = Cliente.builder()
                .idclient(clientedto.getIdclient())
                .nombre(clientedto.getNombre())
                .lastname(clientedto.getLastname())
                .email(clientedto.getEmail())
                .dateregistry(clientedto.getDateregistry())
                .build();
        return clientRepository.save(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {


        clientRepository.delete(cliente);
    }

    @Override
    public boolean existsById(Long id) {
        return clientRepository.existsById(id);
    }
}
