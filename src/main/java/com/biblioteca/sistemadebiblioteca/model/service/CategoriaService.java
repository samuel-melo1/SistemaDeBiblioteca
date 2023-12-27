package com.biblioteca.sistemadebiblioteca.model.service;

import com.biblioteca.sistemadebiblioteca.model.dto.CategoriaDTO;
import com.biblioteca.sistemadebiblioteca.model.exceptions.CategoriaException;
import com.biblioteca.sistemadebiblioteca.model.domain.Categoria;
import com.biblioteca.sistemadebiblioteca.model.repository.CategoriaRepository;
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
            throw new CategoriaException("Não existe Categoria cadastrada!");
        }
        return categoriaRepository.findAll();
    }
}
