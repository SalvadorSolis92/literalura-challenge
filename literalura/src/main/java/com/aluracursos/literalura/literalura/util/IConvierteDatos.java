package com.aluracursos.literalura.literalura.util;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
