package com.biblioteca.sistemadebiblioteca.model.dto;

import com.biblioteca.sistemadebiblioteca.model.domain.Livro;

import java.time.LocalDate;

public record EmprestimoDTO(LocalDate data_emprestimo, LocalDate prazo, Livro livro) {
}
