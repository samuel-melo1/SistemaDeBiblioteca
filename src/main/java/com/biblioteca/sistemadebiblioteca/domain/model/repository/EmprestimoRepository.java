package com.biblioteca.sistemadebiblioteca.domain.model.repository;

import com.biblioteca.sistemadebiblioteca.domain.model.domain.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Integer> {



}
