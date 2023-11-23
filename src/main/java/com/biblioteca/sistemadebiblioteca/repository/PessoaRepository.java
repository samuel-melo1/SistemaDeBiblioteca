package com.biblioteca.sistemadebiblioteca.repository;

import com.biblioteca.sistemadebiblioteca.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
