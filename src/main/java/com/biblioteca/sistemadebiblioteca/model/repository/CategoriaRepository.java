package com.biblioteca.sistemadebiblioteca.model.repository;

import com.biblioteca.sistemadebiblioteca.model.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    boolean existsCategoriaByNome(String nome);
}
