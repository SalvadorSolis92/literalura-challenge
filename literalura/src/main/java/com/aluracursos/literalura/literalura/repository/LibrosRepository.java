package com.aluracursos.literalura.literalura.repository;

import com.aluracursos.literalura.literalura.model.Lenguaje;
import com.aluracursos.literalura.literalura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibrosRepository extends JpaRepository<Libro, Long> {

    List<Libro> findAllByLenguaje(Lenguaje idioma);
}
