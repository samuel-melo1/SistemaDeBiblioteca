package com.biblioteca.sistemadebiblioteca.model.service;

import com.biblioteca.sistemadebiblioteca.model.dto.CategoriaDTO;
import com.biblioteca.sistemadebiblioteca.model.exceptions.CategoriaException;
import com.biblioteca.sistemadebiblioteca.model.domain.Categoria;
import com.biblioteca.sistemadebiblioteca.model.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    private CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria create(CategoriaDTO categoriaDTO){
        if(categoriaRepository.existsCategoriaByNome(categoriaDTO.nome())){
            throw new CategoriaException("Categoria já existe!");
        }
        Categoria newCategoria = new Categoria(categoriaDTO.nome(), categoriaDTO.descricao(), categoriaDTO.livro());
        return categoriaRepository.save(newCategoria);
    }
}
