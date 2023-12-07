package com.biblioteca.sistemadebiblioteca.model.dto;

import com.biblioteca.sistemadebiblioteca.model.domain.Livro;

import java.util.List;

public record CategoriaDTO(String nome, String descricao, List<Livro> livro) {
}
