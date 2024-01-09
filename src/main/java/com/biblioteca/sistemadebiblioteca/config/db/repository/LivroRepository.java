package com.biblioteca.sistemadebiblioteca.config.db.repository;

import com.biblioteca.sistemadebiblioteca.domain.model.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Integer> {

    boolean existsLivroByTitulo(String titulo);
    Livro findLivroByTitulo(String titulo);
}
