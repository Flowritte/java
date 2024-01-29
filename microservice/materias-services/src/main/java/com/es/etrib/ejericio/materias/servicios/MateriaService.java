package com.es.etrib.ejericio.materias.servicios;


import com.es.etrib.ejericio.materias.entity.Materias;
import com.es.etrib.ejericio.materias.repocitory.MateriaRepocitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaService {

    @Autowired
    private MateriaRepocitory materiaRepocitory;

    public List<Materias> getAll(){
        return materiaRepocitory.findAll();
    }

    public Materias getMateriaById(int id){
        return materiaRepocitory.findById(id).orElse(null);
    }
    public Materias save(Materias materias){
        Materias newmateria = materiaRepocitory.save(materias);
        return newmateria;
    }
    public List<Materias> byAlumnoId(int materiaId){
        return materiaRepocitory.findByAlumno(materiaId);
    }
}
