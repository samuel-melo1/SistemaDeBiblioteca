package com.biblioteca.sistemadebiblioteca.domain.repository;

import com.biblioteca.sistemadebiblioteca.domain.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Integer> {



}
