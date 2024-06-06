package com.aluracursos.literalura.literalura.principal;

import com.aluracursos.literalura.literalura.repository.LibrosRepository;

import java.util.Scanner;

public class Principal {

    //entrada desde consola
    private Scanner teclado = new Scanner(System.in);

    private LibrosRepository repository;

    public  Principal(LibrosRepository repository){
        this.repository = repository;
    }

    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    1 - Buscar libro 
                    0 - Salir
                    
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:

                    break;

                default:
                    System.out.println("Opción inválida");
            }
        }
    }

}

