package com.aluracursos.literalura.literalura.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "libros")
public class Libros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLibro;

    private String titulo;

    private List<String> subtitulos;

    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Persona> autores;

    private List<Persona> traductores;

    private List<String> estanteria;

    private List<String> lenguajes;

    private boolean copyright;

    private String mediaType;

    private Formato formatos;

    private Long conteoDescargas;

    public Libros() {

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

    public List<Persona> getAutores() {
        return autores;
    }

    public void setAutores(List<Persona> autores) {
        this.autores = autores;
    }

    public List<Persona> getTraductores() {
        return traductores;
    }

    public void setTraductores(List<Persona> traductores) {
        this.traductores = traductores;
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

    public Formato getFormatos() {
        return formatos;
    }

    public void setFormatos(Formato formatos) {
        this.formatos = formatos;
    }

    public Long getConteoDescargas() {
        return conteoDescargas;
    }

    public void setConteoDescargas(Long conteoDescargas) {
        this.conteoDescargas = conteoDescargas;
    }
}
