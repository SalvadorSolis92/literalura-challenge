package com.aluracursos.literalura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(
        @JsonAlias("id") Long idLibro,
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<DatosAutor> autores,
        @JsonAlias("translators") List<DatoTraductor> traductores,
        @JsonAlias("subjects") List<String> subtitulos,
        @JsonAlias("bookshelves") String estanterias,
        @JsonAlias("languages") String idiomas,
        @JsonAlias("copyright") boolean copyright,
        @JsonAlias("media_type") String mediaType,
        @JsonAlias("formats") Map<String, String> formatos,
        @JsonAlias("download_count") Long conteoDescargas
) {
}