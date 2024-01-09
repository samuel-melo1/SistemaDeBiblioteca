package com.biblioteca.sistemadebiblioteca.domain.model.dto;

import com.biblioteca.sistemadebiblioteca.domain.model.entity.Categoria;

public record LivroDTO(String titulo, Categoria categoria) {
}
