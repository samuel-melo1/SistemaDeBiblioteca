package com.biblioteca.sistemadebiblioteca.repository;

import com.biblioteca.sistemadebiblioteca.domain.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Integer> {



}
