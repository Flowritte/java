package com.es.etrib.service;

import com.es.etrib.configuracion.RestTemplateconfig;
import com.es.etrib.entity.Alumnos;
import com.es.etrib.modelo.Materia;
import com.es.etrib.repocitory.AlumnosRepocitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AlumnoServicio {

    @Autowired//resttamplaete es para la comunicacion de los miscroservicios
    private RestTemplate restTemplate;

    @Autowired
    private AlumnosRepocitory alumnosRepocitory;


    //metodo para obtener las materias de cada alumno cuya entrada es el id del alumno
    public List<Materia> getmaterias(int alumnoId){

        /*lista obtenida atravz de la comunicacion del microservicio de materias poer comunicacion http
          donde se obtiene el todos valores de materias enforma de lista y retorna la lista como objeto

         */
        List<Materia> materias =
                restTemplate.getForObject("http://localhost:8001/materia/alumno/"+alumnoId,List.class);
        return materias;
    }

    //metodo para obtener todos los alumnos
    public List<Alumnos> getAll(){
        return alumnosRepocitory.findAll();
    }

    //metodo apra obtener elalumno por id
    public Alumnos getAlumnoById(int id){
        return alumnosRepocitory.findById(id).orElse(null);
    }

    //metodo para guardar alumnos
    public Alumnos save(Alumnos alumnos){
        Alumnos newalumno = alumnosRepocitory.save(alumnos);
        return newalumno;
    }

}
