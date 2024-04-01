package com.biblioteca.sistemadebiblioteca.domain.service;

import com.biblioteca.sistemadebiblioteca.config.infra.exceptions.categoriaException.CategoriaExistException;
import com.biblioteca.sistemadebiblioteca.domain.model.Categoria;
import com.biblioteca.sistemadebiblioteca.domain.dto.CategoriaDTO;
import com.biblioteca.sistemadebiblioteca.repository.CategoriaRepository;
import com.biblioteca.sistemadebiblioteca.config.infra.exceptions.categoriaException.CategoriaNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria create(CategoriaDTO categoriaDTO) {
        if (categoriaRepository.existsCategoriaByNome(categoriaDTO.nome())) {
            throw new CategoriaExistException();
        }
        return categoriaRepository.save(Categoria.builder()
                .nome(categoriaDTO.nome())
                .descricao(categoriaDTO.descricao()).build());
    }

    public List<Categoria> getCategorias() {
        if (categoriaRepository.findAll().isEmpty()) {
            throw new CategoriaNotFoundException();
        }
        return categoriaRepository.findAll();
    }
}
