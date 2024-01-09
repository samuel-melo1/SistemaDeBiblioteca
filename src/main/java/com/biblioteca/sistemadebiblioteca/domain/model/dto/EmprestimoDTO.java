package com.biblioteca.sistemadebiblioteca.domain.model.dto;

import com.biblioteca.sistemadebiblioteca.domain.model.entity.Livro;
import com.biblioteca.sistemadebiblioteca.domain.model.entity.Pessoa;

import java.time.LocalDate;


public record EmprestimoDTO(LocalDate data_emprestimo, LocalDate prazo, Livro livro, Pessoa pessoa) {
}
