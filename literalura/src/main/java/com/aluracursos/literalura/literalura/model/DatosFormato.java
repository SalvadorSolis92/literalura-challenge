package com.aluracursos.literalura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosFormato(
        @JsonAlias("mimeType") String mimeType,
        @JsonAlias("url") String url
) {
}
