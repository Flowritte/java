package com.es.ori.microservice.clientes.DTO;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;




@ToString
@Builder
@Data
public class ClienteDTO {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idclient;

    @Column(name = "name")
    private  String nombre;

    @Column(name = "last_name")
    private String lastname;

    private String email;

    @Column(name = "date_registry")
    private Date dateregistry;
}
