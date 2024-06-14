package com.aluracursos.literalura.literalura.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name = "libros")
public class Libro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro")
    private Long idLibro;

    @Column(name = "titulo")
    private String titulo;

    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Autor> autores;

    @Column(name = "lenguaje")
    private Lenguaje lenguaje;

    @Column(name = "conteo_descargas")
    private Long conteoDescargas;

    public Libro() {

    }

    public Libro(DatosLibro datosLibro){
        this.titulo = datosLibro.titulo();
        this.lenguaje =  Lenguaje.fromString(datosLibro.idiomas().get(0));
        this.conteoDescargas = datosLibro.conteoDescargas() != null ? datosLibro.conteoDescargas() : 0;
    }

    public Long getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Long idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public Lenguaje getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(Lenguaje lenguaje) {
        this.lenguaje = lenguaje;
    }

    public Long getConteoDescargas() {
        return conteoDescargas;
    }

    public void setConteoDescargas(Long conteoDescargas) {
        this.conteoDescargas = conteoDescargas;
    }

    @Override
    public String toString() {
        //Datos solicitados en el plan de trello
        return "------------------------------"
                + "Titulo: " + this.titulo
                + "\nAutor(es): " + this.autores.stream().map(Autor::toString).collect(Collectors.joining(", "))
                + "\nIdiomas: " + this.lenguaje
                + "\nNúmero de descargas: " + conteoDescargas
                + "\n------------------------------------------------------------\n\n";

    }
}
