package com.es.etrib.modelo;



public class Materia {

    private String nombre;
    private String alumnos;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(String alumnos) {
        this.alumnos = alumnos;
    }

    public Materia(String nombre, String alumnos) {
        this.nombre = nombre;
        this.alumnos = alumnos;
    }

    public Materia() {
    }
}
