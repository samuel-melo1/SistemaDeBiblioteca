package com.biblioteca.sistemadebiblioteca.config.db.repository;

import com.biblioteca.sistemadebiblioteca.domain.model.entity.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Integer> {



}
