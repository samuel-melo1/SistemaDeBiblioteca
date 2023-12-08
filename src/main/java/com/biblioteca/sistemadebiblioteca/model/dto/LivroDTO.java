package com.biblioteca.sistemadebiblioteca.model.dto;

import com.biblioteca.sistemadebiblioteca.model.domain.Categoria;
import com.biblioteca.sistemadebiblioteca.model.domain.Emprestimo;

import java.util.List;

public record LivroDTO(String titulo, Categoria categoria) {
}
