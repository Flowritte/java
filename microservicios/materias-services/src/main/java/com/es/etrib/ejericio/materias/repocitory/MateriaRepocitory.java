package com.es.etrib.ejericio.materias.repocitory;

import com.es.etrib.ejericio.materias.entity.Materias;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MateriaRepocitory extends JpaRepository<Materias,Integer> {

    List<Materias> findByAlumno(int usuarioId);
}
