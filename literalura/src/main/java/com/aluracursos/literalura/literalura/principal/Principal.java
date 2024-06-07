package com.aluracursos.literalura.literalura.principal;

import com.aluracursos.literalura.literalura.model.DatosBusqueda;
import com.aluracursos.literalura.literalura.repository.LibrosRepository;
import com.aluracursos.literalura.literalura.service.ClientHttp;
import com.aluracursos.literalura.literalura.util.ConvierteDatos;

import java.util.List;
import java.util.Scanner;

public class Principal {

    //Cliente http
    private ClientHttp client = new ClientHttp();
    //liga api
    private final String URL_BASE = "https://gutendex.com";
    //entrada desde consola
    private Scanner teclado = new Scanner(System.in);
    //Conversor de datos json a objetos
    private ConvierteDatos conversor = new ConvierteDatos();

    private LibrosRepository repository;

    public  Principal(LibrosRepository repository){
        this.repository = repository;
    }

    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    1 - Buscar libro por titulo
                    2 - Listar libros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos en un año determinado
                    5 - Listar libros por idioma
                    0 - Salir
                    
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    this.buscarLibroPorTitulo();
                    break;

                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private DatosBusqueda obtenerDatosPorTitulo(){
        System.out.println("Escribe el titulo del libro que deseas buscar");
        var tituloSearch = teclado.nextLine();
        var json = client.obtenerDatos(URL_BASE + "/books/?search=" + tituloSearch.replace(" ", "%20"));
        DatosBusqueda datos = conversor.obtenerDatos(json, DatosBusqueda.class);
        return datos;
    }

    private void buscarLibroPorTitulo(){
        DatosBusqueda librosEncontrados = obtenerDatosPorTitulo();

        if(librosEncontrados != null){
            System.out.println("se encontro con exito");
        }else{
            System.out.println("error en busqueda");
        }

    }

}

