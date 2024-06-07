package com.aluracursos.literalura.literalura.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "formato")
public class Formato implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_formato")
    private Long idFormato;

    @Column(name = "url")
    private String url;

    @JoinColumn(name = "formato_id_libro", referencedColumnName = "id_libro")
    private Libros libro;

    public Formato() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getIdFormato() {
        return idFormato;
    }

    public void setIdFormato(Long idFormato) {
        this.idFormato = idFormato;
    }

    public Libros getLibro() {
        return libro;
    }

    public void setLibro(Libros libro) {
        this.libro = libro;
    }
}
