package com.es.microservice.student;


import com.es.microservice.student.Entities.Students;

import java.util.List;

public interface IStudentService {

    List<Students> findAll(); //busqueda de todos los estudiantes

    Students findById(Long id); //busqueda por id de estudiante

    void save(Students student);    //metodo para guardar al nuevo estudiante

    List<Students> findByIdCourse(Long idCourse); //metodo para listar todos los estudiantes por id del curso
}
