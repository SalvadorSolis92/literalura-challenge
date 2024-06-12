package com.aluracursos.literalura.literalura.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.List;

@Entity
public class Traductor extends Persona{

    @ManyToOne
    private Libros libro;

    public Traductor(String nombre, int anioNacimiento, int anioDefuncion) {
        this.setNombre(nombre);
        this.setAnioNacimiento(anioNacimiento);
        this.setAnioDefuncion(anioDefuncion);
    }

    public Libros getLibro() {
        return libro;
    }

    public void setLibro(Libros libro) {
        this.libro = libro;
    }
}
