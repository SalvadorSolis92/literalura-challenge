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

    @Column(name = "mime_type")
    private String mimeType;

    @Column(name = "url")
    private String ulr;

    @ManyToOne(optional = false)
    private Libros libro;

    public Formato() {
    }

    public Long getIdFormato() {
        return idFormato;
    }

    public void setIdFormato(Long idFormato) {
        this.idFormato = idFormato;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getUlr() {
        return ulr;
    }

    public void setUlr(String ulr) {
        this.ulr = ulr;
    }

    public Libros getLibro() {
        return libro;
    }

    public void setLibro(Libros libro) {
        this.libro = libro;
    }
}
