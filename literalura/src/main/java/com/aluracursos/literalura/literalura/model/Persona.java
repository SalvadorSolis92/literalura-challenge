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

    @Column(name = "anio_nacimiento")
    private int anioNacimiento;

    @Column(name = "anio_defuncion")
    private int anioDefuncion;

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

    public int getAnioNacimiento() {
        return anioNacimiento;
    }

    public void setAnioNacimiento(int anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }

    public int getAnioDefuncion() {
        return anioDefuncion;
    }

    public void setAnioDefuncion(int anioDefuncion) {
        this.anioDefuncion = anioDefuncion;
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
