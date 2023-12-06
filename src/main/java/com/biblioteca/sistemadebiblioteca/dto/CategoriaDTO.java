package com.biblioteca.sistemadebiblioteca.dto;

import com.biblioteca.sistemadebiblioteca.model.Livro;

import java.util.List;

public record CategoriaDTO(String nome, String descricao, List<Livro> livro) {
}
