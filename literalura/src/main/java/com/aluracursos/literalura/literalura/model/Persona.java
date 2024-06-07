package com.aluracursos.literalura.literalura.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "persona")
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Long idPersona;

    @Column(name = "fecha_cumpleanios")
    private int fechaCumpleanios;

    @Column(name = "fecha_defuncion")
    private int fechaDefuncion;

    @Column(name = "nombre")
    private String nombre;

    @ManyToMany(mappedBy = "autores")
    private List<Libros> librosComoAutor;

    @ManyToMany(mappedBy = "traductores")
    private List<Libros> librosComoTraductor;

    public Persona() {
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public int getFechaCumpleanios() {
        return fechaCumpleanios;
    }

    public void setFechaCumpleanios(int fechaCumpleanios) {
        this.fechaCumpleanios = fechaCumpleanios;
    }

    public int getFechaDefuncion() {
        return fechaDefuncion;
    }

    public void setFechaDefuncion(int fechaDefuncion) {
        this.fechaDefuncion = fechaDefuncion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Libros> getLibrosComoAutor() {
        return librosComoAutor;
    }

    public void setLibrosComoAutor(List<Libros> librosComoAutor) {
        this.librosComoAutor = librosComoAutor;
    }

    public List<Libros> getLibrosComoTraductor() {
        return librosComoTraductor;
    }

    public void setLibrosComoTraductor(List<Libros> librosComoTraductor) {
        this.librosComoTraductor = librosComoTraductor;
    }
}
