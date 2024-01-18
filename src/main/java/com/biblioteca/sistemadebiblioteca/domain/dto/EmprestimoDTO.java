package com.biblioteca.sistemadebiblioteca.domain.dto;

import com.biblioteca.sistemadebiblioteca.domain.model.Livro;
import com.biblioteca.sistemadebiblioteca.domain.model.Pessoa;

import java.time.LocalDate;


public record EmprestimoDTO(LocalDate data_emprestimo, LocalDate prazo, Livro livro, Pessoa pessoa) {
}
