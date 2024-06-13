package com.aluracursos.literalura.literalura.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Map;

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
    private Libro libro;

    public Formato() {
    }

    public Formato(String mimeType, String url) {
        this.mimeType = mimeType;
        this.ulr = url;
    }

    public Formato(Map.Entry<String, String> f) {

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

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
}
