package com.aluracursos.literalura.literalura.repository;

import com.aluracursos.literalura.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutoresRepostory extends JpaRepository<Autor, Long> {

    @Query(value = "SELECT a FROM Autor a WHERE a.anioNacimiento <= :anioBusqueda AND a.anioDefuncion >= :anioBusqueda")
    List<Autor> findAllAnioLive(int anioBusqueda);

    List<Autor> findByAnioNacimientoLessThanEqualAndAnioDefuncionGreaterThanEqual(int limiteInferior, int limiteSuperior);
}
