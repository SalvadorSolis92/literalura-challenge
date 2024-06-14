package com.aluracursos.literalura.literalura.model;

public enum Lenguaje {
    ES("es", "Español"),
    EN("en", "Ingles"),
    FR("fr", "Frances"),
    FI("fi", "Finlandés"),
    AL("al", "Alemán");


    private String idiomaAbreviacion;
    private String idiomaEspaniol;

    Lenguaje(String idiomaAbreviacion, String idiomaEspaniol) {
        this.idiomaAbreviacion = idiomaAbreviacion;
        this.idiomaEspaniol = idiomaEspaniol;
    }

    public static Lenguaje fromString(String text){
        for(Lenguaje lenguaje: Lenguaje.values()){
            if (lenguaje.idiomaAbreviacion.equalsIgnoreCase(text)){
                return lenguaje;
            }
        }
        throw new IllegalArgumentException("El lenguaje no esta en la lista de traduccón " + text);
    }

    public static Lenguaje fromEspaniol(String text){
        for(Lenguaje lenguaje: Lenguaje.values()){
            if (lenguaje.idiomaEspaniol.equalsIgnoreCase(text)){
                return lenguaje;
            }
        }
        throw new IllegalArgumentException("El lenguaje no esta en la lista de traduccón " + text);
    }
}
