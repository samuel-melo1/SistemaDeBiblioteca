package com.biblioteca.sistemadebiblioteca.service;

import com.biblioteca.sistemadebiblioteca.dto.CategoriaDTO;
import com.biblioteca.sistemadebiblioteca.exceptions.CategoriaException;
import com.biblioteca.sistemadebiblioteca.model.Categoria;
import com.biblioteca.sistemadebiblioteca.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    private CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria create(CategoriaDTO categoriaDTO){
        if(categoriaRepository.findCategoriaByNome(categoriaDTO.nome())){
            throw new CategoriaException("Categoria já existe!");
        }
        Categoria newCategoria = new Categoria(categoriaDTO.nome(), categoriaDTO.descricao(), categoriaDTO.livro());
        return categoriaRepository.save(newCategoria);
    }
}
