package com.aluracursos.literalura.literalura.repository;

import com.aluracursos.literalura.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoresRepostory extends JpaRepository<Autor, Long> {
}
