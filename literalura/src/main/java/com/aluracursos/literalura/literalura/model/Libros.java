package com.aluracursos.literalura.literalura.model;

import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class Libros {

    private Long idLibro;
    private String titulo;
    private List<String> subtitulos;
    private List<Persona> autores;
    private List<Persona> traductores;
    private List<String> estanteria;
    private List<String> lenguajes;
    private boolean copyright;
    private String mediaType;
    private String formatos;
    private Long conteoDescargas;
}
