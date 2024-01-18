package com.biblioteca.sistemadebiblioteca.domain.repository;

import com.biblioteca.sistemadebiblioteca.domain.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Integer> {

    boolean existsLivroByTitulo(String titulo);
    Livro findLivroByTitulo(String titulo);
}
