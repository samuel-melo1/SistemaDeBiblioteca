package com.biblioteca.sistemadebiblioteca.domain.dto;

import com.biblioteca.sistemadebiblioteca.domain.model.Categoria;

public record LivroDTO(String titulo, Categoria categoria) {
}
