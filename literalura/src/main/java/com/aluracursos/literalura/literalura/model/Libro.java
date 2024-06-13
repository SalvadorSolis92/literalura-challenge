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

    @Column(name = "subtitulos")
    private List<String> subtitulos;

    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Autor> autores;

    @Column(name = "estanteria")
    private List<String> estanteria;

    @Column(name = "lenguajes")
    private List<String> lenguajes;

    @Column(name = "copyright")
    private boolean copyright;

    @Column(name = "mediaType")
    private String mediaType;

    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Formato> formatos;

    @Column(name = "conteo_descargas")
    private Long conteoDescargas;

    public Libro() {

    }

    public Libro(DatosLibro datosLibro){
        this.titulo = datosLibro.titulo();
        this.subtitulos = datosLibro.subtitulos();
        this.estanteria = datosLibro.estanterias();
        this.lenguajes = datosLibro.idiomas();
        this.copyright = datosLibro.copyright();
        this.mediaType = datosLibro.mediaType();
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

    public List<String> getSubtitulos() {
        return subtitulos;
    }

    public void setSubtitulos(List<String> subtitulos) {
        this.subtitulos = subtitulos;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public List<String> getEstanteria() {
        return estanteria;
    }

    public void setEstanteria(List<String> estanteria) {
        this.estanteria = estanteria;
    }

    public List<String> getLenguajes() {
        return lenguajes;
    }

    public void setLenguajes(List<String> lenguajes) {
        this.lenguajes = lenguajes;
    }

    public boolean isCopyright() {
        return copyright;
    }

    public void setCopyright(boolean copyright) {
        this.copyright = copyright;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public List<Formato> getFormatos() {
        return formatos;
    }

    public void setFormatos(List<Formato> formatos) {
        this.formatos = formatos;
    }

    public Long getConteoDescargas() {
        return conteoDescargas;
    }

    public void setConteoDescargas(Long conteoDescargas) {
        this.conteoDescargas = conteoDescargas;
    }

    @Override
    public String toString() {
        return "------------------------------"
                + "Titulo: " + this.titulo
                + "\nIdiomas: " + this.lenguajes.stream().collect(Collectors.joining(", "))
                + "\nAutores: " + this.autores.stream().map(Autor::toString).collect(Collectors.joining(", "))
                + "\nEstanteria: " + this.estanteria.stream().collect(Collectors.joining(", "))
                + "\nCopyright: " + copyright
                + "\nMedia Type: " + mediaType
                + "\nformatos: " + formatos
                + "\nConteo de descargas: " + conteoDescargas
                + "\n------------------------------------------------------------\n\n";
    }
}
