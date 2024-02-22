package com.es.ori.microservice.clientes.controller;

import com.es.ori.microservice.clientes.DTO.ClienteDTO;
import com.es.ori.microservice.clientes.Entities.Cliente;
import com.es.ori.microservice.clientes.Http.Response.Respoce;
import com.es.ori.microservice.clientes.Service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ControllerCliente {

    @Autowired
    private IClienteService iClienteService;

    @GetMapping("clientes")
    public ResponseEntity<?> findAll(){
        List<Cliente> getall = iClienteService.findAll();
        if(getall == null){
            return new ResponseEntity<>(
                    Respoce.builder()
                            .mensaje("No hay registros por buscar")
                            .object(null)
                            .build(), HttpStatus.OK
            );
        }
        return new ResponseEntity<>(
                Respoce.builder()
                        .mensaje("")
                        .object(getall)
                        .build(),HttpStatus.OK
        );
    }

    @PostMapping("/cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody ClienteDTO clienteDTO){
        Cliente clientesave = null;
        try{
            clientesave =  iClienteService.save(clienteDTO);
            clienteDTO = ClienteDTO.builder()
                    .idclient(clientesave.getIdclient())
                    .nombre(clientesave.getNombre())
                    .lastname(clientesave.getLastname())
                    .email(clientesave.getEmail())
                    .dateregistry(clientesave.getDateregistry())
                    .build();
            return new ResponseEntity<>(Respoce.builder().mensaje("Guardado exitosamente")
                    .object(clienteDTO).build(),HttpStatus.CREATED);
        }catch (DataAccessException DAE){

            return new ResponseEntity<>(
                    Respoce.builder()
                            .mensaje(DAE.getMessage())
                            .object(null)
                            .build() , HttpStatus.METHOD_NOT_ALLOWED
            );
        }


    }

    @PutMapping("/cliente/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO){

        Cliente clienteupdate = null;
        try {

            if(iClienteService.existsById(id)){
                clienteDTO.setIdclient(id);
                clienteupdate = iClienteService.save(clienteDTO);
                return new ResponseEntity<>(Respoce.builder()
                        .mensaje("se han actualizado los datos")
                        .object(ClienteDTO.builder()
                                .idclient(clienteupdate.getIdclient())
                                .nombre(clienteupdate.getNombre())
                                .lastname(clienteupdate.getLastname())
                                .email(clienteupdate.getEmail())
                                .dateregistry(clienteupdate.getDateregistry())
                                .build())
                        .build(),HttpStatus.CREATED);
            }else {
                return new ResponseEntity<>(Respoce.builder()
                        .mensaje("El registro que itenta actualizar no se encuentra en la base")
                        .object(null).build(),HttpStatus.NOT_FOUND);
            }

        }catch (DataAccessException DAE){
            return  new ResponseEntity<>(Respoce.builder()
                    .mensaje(DAE.getMessage())
                    .object(null).build(),HttpStatus.METHOD_NOT_ALLOWED);

        }
    }

    @DeleteMapping( "/cliente_dele/{id}")
   public ResponseEntity<?> delete(@PathVariable Long id) {

        try {
            Cliente clientedlete = iClienteService.findById(id);
            iClienteService.delete(clientedlete);
            return new ResponseEntity<>(clientedlete,HttpStatus.NO_CONTENT);

        } catch (DataAccessException exDt) {

            return new ResponseEntity<>(Respoce.builder()
                    .mensaje(exDt.getMessage())
                    .object(null).build()
                    ,HttpStatus.METHOD_NOT_ALLOWED);
            }
    }


    @GetMapping("/cliente/{id}")

    public ResponseEntity<?> ShowById(@PathVariable Long id){

        Cliente clienteid = iClienteService.findById(id);

        if(clienteid == null){
            return new ResponseEntity<>(Respoce.builder()
                    .mensaje("El registro que busca no existe")
                    .object(null).build()
                    ,HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(Respoce.builder()
                .mensaje("")
                .object(ClienteDTO.builder()
                        .idclient(clienteid.getIdclient())
                        .nombre(clienteid.getNombre())
                        .lastname(clienteid.getLastname())
                        .email(clienteid.getEmail())
                        .dateregistry(clienteid.getDateregistry())
                        .build()).build()
                ,HttpStatus.OK);
    }
}
