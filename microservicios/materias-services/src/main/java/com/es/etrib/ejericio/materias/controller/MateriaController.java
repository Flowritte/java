package com.es.etrib.ejericio.materias.controller;


import com.es.etrib.ejericio.materias.entity.Materias;
import com.es.etrib.ejericio.materias.servicios.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materia")
public class MateriaController {

    @Autowired
    private MateriaService materiaService;

    @GetMapping
    public ResponseEntity<List<Materias>> listrMaterias(){
        List<Materias> materias = materiaService.getAll();
        if (materias.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(materias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Materias> obtenerMaterias(@PathVariable("id") int id){

        Materias materias = materiaService.getMateriaById(id);
        if(materias == null){

            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(materias);
    }

    @PostMapping
    public ResponseEntity<Materias> guardarMaterias(@RequestBody Materias materias){
        Materias newmaterias = materiaService.save(materias);
        return ResponseEntity.ok(newmaterias);
    }

    @GetMapping("/alumnos/{alumnoId}")
    public ResponseEntity<List<Materias>>  listarPorAlumno(@PathVariable("alumnoId") int id){

        List<Materias> materias = materiaService.byAlumnoId(id);
        if (materias.isEmpty()){

            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(materias);
    }
}
