package com.es.etrib.controller;

import com.es.etrib.entity.Alumnos;
import com.es.etrib.modelo.Materia;
import com.es.etrib.service.AlumnoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


//clase para la busqueda y operaciones que permite interactuar con el microservicio

@RequestMapping("/alumno")
@RestController
public class AlumnoController {

    @Autowired
    private AlumnoServicio alumnoServicio;

    //metodo para listar usuario
    @GetMapping
    public ResponseEntity<List<Alumnos>> listarAlumnos() {
        List<Alumnos> alumnos = alumnoServicio.getAll();
        if (alumnos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(alumnos);
    }

    //metodo para guardar usuario
    @PostMapping
    public ResponseEntity<Alumnos> guardaralumno(@Valid @RequestBody Alumnos alumnos){
        Alumnos newAlumno = alumnoServicio.save(alumnos);
        return ResponseEntity.ok(newAlumno);
    }

    //() funciona comola ruta para buscar este metodo para la comunicacion para http
    @GetMapping("/{id}")
    public ResponseEntity<Alumnos> obtenerAlumno(@PathVariable("id")int id){

         Alumnos alumnos = alumnoServicio.getAlumnoById(id);
         if (alumnos == null){
            return ResponseEntity.notFound().build();
         }
            return ResponseEntity.ok(alumnos);
    }

    @GetMapping("/Materia/{alumnoId}")
    public ResponseEntity<List<Materia>> getmaterias(@PathVariable("alumnoId") int id){

        Alumnos alumnos = alumnoServicio.getAlumnoById(id);
        if(alumnos== null){
            return ResponseEntity.notFound().build();
        }
        List<Materia> materias = alumnoServicio.getmaterias(id);
        return ResponseEntity.ok(materias);
    }

}