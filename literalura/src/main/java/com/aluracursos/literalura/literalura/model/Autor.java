package com.aluracursos.literalura.literalura.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Autor{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_autor")
    private Long idAutor;
    private String nombre;
    private int anioNacimiento;
    private int anioDefuncion;

    @ManyToOne
    @JoinColumn(name = "libro_id")
    private Libro libro;

    public Autor() {
    }

    public Autor(String nombre, int anioNacimiento, int anioDefuncion) {
        this.nombre = nombre;
        this.anioNacimiento = anioNacimiento;
        this.anioDefuncion = anioDefuncion;
    }

    public int getAnioDefuncion() {
        return anioDefuncion;
    }

    public void setAnioDefuncion(int anioDefuncion) {
        this.anioDefuncion = anioDefuncion;
    }

    public int getAnioNacimiento() {
        return anioNacimiento;
    }

    public void setAnioNacimiento(int anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    @Override
    public String toString() {
        return  "\n\t" + this.nombre
                + "\n\tAño nacimiento: " + this.anioNacimiento
                + "\n\tAño defunción: " + this.anioDefuncion;
    }
}
