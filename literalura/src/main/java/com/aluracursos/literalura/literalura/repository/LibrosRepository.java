package com.aluracursos.literalura.literalura.repository;

import com.aluracursos.literalura.literalura.model.Libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrosRepository extends JpaRepository<Libros, Long> {

}
