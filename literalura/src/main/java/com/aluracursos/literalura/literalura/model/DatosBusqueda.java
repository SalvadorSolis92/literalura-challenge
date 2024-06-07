package com.aluracursos.literalura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record DatosBusqueda(
        @JsonAlias("count") Long numResultados,
        @JsonAlias("next") String siguiente,
        @JsonAlias("previous") String previo
        //@JsonAlias("results") List<DatosLibro> libros
) {
}
