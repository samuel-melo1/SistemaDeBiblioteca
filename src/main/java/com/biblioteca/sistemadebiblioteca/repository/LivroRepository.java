package com.biblioteca.sistemadebiblioteca.repository;

import com.biblioteca.sistemadebiblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Integer> {

    boolean existsLivroByTitulo(String titulo);
}
