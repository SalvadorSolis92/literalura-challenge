package com.aluracursos.literalura.literalura.model;

import jakarta.persistence.*;

import java.io.Serializable;

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

    @ManyToOne(optional = false)
    private Libros libro;

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

    public Libros getLibro() {
        return libro;
    }

    public void setLibro(Libros libro) {
        this.libro = libro;
    }
}
