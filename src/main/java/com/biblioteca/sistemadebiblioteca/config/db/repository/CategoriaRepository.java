package com.biblioteca.sistemadebiblioteca.config.db.repository;

import com.biblioteca.sistemadebiblioteca.domain.model.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    boolean existsCategoriaByNome(String nome);
}
