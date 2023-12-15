package com.biblioteca.sistemadebiblioteca.model.repository;

import com.biblioteca.sistemadebiblioteca.model.domain.Emprestimo;
import com.biblioteca.sistemadebiblioteca.model.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Integer> {



}
