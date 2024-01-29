package com.es.etrib.repocitory;

import com.es.etrib.entity.Alumnos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnosRepocitory extends JpaRepository<Alumnos,Integer> {


}
