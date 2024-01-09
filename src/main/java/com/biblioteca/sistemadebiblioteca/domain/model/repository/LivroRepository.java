package com.biblioteca.sistemadebiblioteca.domain.model.repository;

import com.biblioteca.sistemadebiblioteca.domain.model.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Integer> {

    boolean existsLivroByTitulo(String titulo);
    Livro findLivroByTitulo(String titulo);
}
