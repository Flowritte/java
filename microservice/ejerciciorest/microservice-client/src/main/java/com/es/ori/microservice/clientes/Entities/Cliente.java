package com.es.ori.microservice.clientes.Entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "clientes")
public class Cliente {

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
