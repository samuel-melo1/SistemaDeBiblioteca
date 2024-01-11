package com.biblioteca.sistemadebiblioteca.domain.service;

import com.biblioteca.sistemadebiblioteca.domain.model.entity.Categoria;
import com.biblioteca.sistemadebiblioteca.domain.model.dto.CategoriaDTO;
import com.biblioteca.sistemadebiblioteca.config.db.repository.CategoriaRepository;
import com.biblioteca.sistemadebiblioteca.config.exceptions.CategoriaException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria create(CategoriaDTO categoriaDTO) throws CategoriaException {
        if (categoriaRepository.existsCategoriaByNome(categoriaDTO.nome())) {
            throw new CategoriaException("Categoria já existe!");
        }
        Categoria newCategoria = new Categoria(categoriaDTO.nome(), categoriaDTO.descricao());
        return categoriaRepository.save(newCategoria);
    }

    public List<Categoria> getCategorias() throws CategoriaException {
        if (categoriaRepository.findAll().isEmpty()) {
            throw new CategoriaException();
        }
        return categoriaRepository.findAll();
    }
}
