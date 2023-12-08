package com.biblioteca.sistemadebiblioteca.model.repository;

import com.biblioteca.sistemadebiblioteca.model.domain.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Integer> {
}
