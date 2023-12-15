package com.biblioteca.sistemadebiblioteca.model.dto;

import com.biblioteca.sistemadebiblioteca.model.domain.Livro;
import com.biblioteca.sistemadebiblioteca.model.domain.Pessoa;

import java.time.LocalDate;


public record EmprestimoDTO(LocalDate data_emprestimo, LocalDate prazo, Livro livro, Pessoa pessoa) {
}
