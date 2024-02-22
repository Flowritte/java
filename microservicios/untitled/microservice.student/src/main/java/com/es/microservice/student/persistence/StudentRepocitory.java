package com.es.microservice.student.persistence;

import com.es.microservice.student.Entities.Students;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//esta es una capa de persistencia de datos
@Repository
public interface StudentRepository extends CrudRepository<Students, Long> {

    List<Students> findAllByStudents(Long idCourse);//query para buscar todos los estudiantes que tengan in cierto id

    //@Query("SELECT s FROM Students s WHERE s.course_id = :IdCourse") //otra forma de buscar
   // List<Students> findAllByStudents(Long idCourse);

}
