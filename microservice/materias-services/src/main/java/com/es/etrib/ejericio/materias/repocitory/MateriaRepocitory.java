package com.es.etrib.ejericio.materias.repocitory;

import com.es.etrib.ejericio.materias.entity.Materias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MateriaRepocitory extends JpaRepository<Materias,Integer> {

    List<Materias> findByAlumno(int usuarioId);
}
