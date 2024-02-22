package com.es.ori.microservice.clientes.Http.Response;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.transaction.annotation.Transactional;

@Data
@ToString
@Builder
public class Respoce {

    private String mensaje;
    private Object object;
}
