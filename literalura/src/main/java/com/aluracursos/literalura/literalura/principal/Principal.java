package com.aluracursos.literalura.literalura.principal;

import com.aluracursos.literalura.literalura.model.*;
import com.aluracursos.literalura.literalura.repository.AutoresRepostory;
import com.aluracursos.literalura.literalura.repository.LibrosRepository;
import com.aluracursos.literalura.literalura.service.ClientHttp;
import com.aluracursos.literalura.literalura.util.ConvierteDatos;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

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
    private AutoresRepostory repostoryAutores;

    public  Principal(LibrosRepository repository, AutoresRepostory autoresRepostory){
        this.repository = repository;
        this.repostoryAutores = autoresRepostory;
    }

    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                     (っ◕‿◕)っ Bienvenido
                    1 - Buscar libro por titulo
                    2 - Listar libros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos en un año determinado
                    5 - Listar libros por idioma
                    0 - Salir
                    
                    """;
            System.out.println(menu);
            try {
                opcion = teclado.nextInt();
                teclado.nextLine();
            }catch (Exception e){
                opcion = 0;
                System.err.println("Error al ingresar opción, intenta otra vez");
            }


            switch (opcion) {
                case 1:
                    this.buscarLibroPorTitulo();
                    break;
                case 2:
                    this.mostrarLibrosRegistrados();
                    break;
                case 0:
                    mensajeDespedida();
                    break;
                default:
                    mensajeOpcionInvalida();
            }
        }
    }


    private void mensajeOpcionInvalida(){
        String error = """
                            
                            
                            (˘_˘٥) Opción invalida, intenta con una opción del ménu
                            
                            
                            
                            """;
        System.out.println(error);
    }

    private void mensajeDespedida(){
        String osito = """
                            ───▄▀▀▀▄▄▄▄▄▄▄▀▀▀▄───
                            ───█▒▒░░░░░░░░░▒▒█───
                            ────█░░█░░░░░█░░█────
                            ─▄▄──█░░░▀█▀░░░█──▄▄─
                            █░░█─▀▄░░░░░░░▄▀─█░░█
                            █▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█
                            ______           \s
                            | ___ \\          \s
                            | |_/ /_   _  ___\s
                            | ___ \\ | | |/ _ \\
                            | |_/ / |_| |  __/
                            \\____/ \\__, |\\___|
                                    __/ |    \s
                                   |___/
                            █▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█
                            """;
        System.out.println(osito);
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

        Optional<DatosLibro> datos = librosEncontrados.libros().stream()
                .findFirst();

        if(datos.isPresent()){
            var datosLibro = datos.get();
            //Datos del libro
            Libro libro = this.repository.save(new Libro(datosLibro));
            //Datos de autores
            List<Autor> autores = datosLibro.autores().stream()
                    .map(a -> new Autor(a.nombre(), a.anioNacimiento(), a.anioDefuncion()))
                    .collect(Collectors.toList());
            autores.forEach(a -> a.setLibro(libro));//relacionar el autor con el libro
            autores.forEach(a -> this.repostoryAutores.save(a));//guardar datos del autor
        }else{
            System.out.println("No se encontrarón resultados, prueba con otro titulo");
        }

    }

    private void mostrarLibrosRegistrados() {
        List<Libro> librosRegistrados = this.repository.findAll();

        librosRegistrados.stream()
                .sorted(Comparator.comparing(Libro::getTitulo))
                .forEach(System.out::println);
    }

}

