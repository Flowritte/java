package com.es.etrib;

import com.es.etrib.entity.Alumnos;
import com.es.etrib.repocitory.AlumnosRepocitory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AlumnoServicio {

    @Autowired
    private AlumnosRepocitory alumnosRepocitory;

    //metodo para obtener todos los alumnos
    public List<Alumnos> getAll(){
        return alumnosRepocitory.findAll();
    }
    //metodo apra obtener elalumno por id
    private   Alumnos getAlumnoById(int id){
        return alumnosRepocitory.findById(id).orElse(null);
    }
    //metodo para guardar alumnos
    public Alumnos save(Alumnos alumnos){
        Alumnos newalumno = alumnosRepocitory.save(alumnos);
        return newalumno;
    }

}
