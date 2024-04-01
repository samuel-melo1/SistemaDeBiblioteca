package com.biblioteca.sistemadebiblioteca.domain.service;

import com.biblioteca.sistemadebiblioteca.config.infra.exceptions.livroException.LivroNotFoundException;
import com.biblioteca.sistemadebiblioteca.domain.Enums.LivroEnum;
import com.biblioteca.sistemadebiblioteca.domain.model.Livro;
import com.biblioteca.sistemadebiblioteca.repository.LivroRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DevolucaoService {

    private LivroService livroService;
    private LivroRepository repository;

    public DevolucaoService(LivroService livroService, LivroRepository repository){
        this.livroService = livroService;
        this.repository = repository;
    }
    @Transactional
    public boolean askDevolution(Integer id_book){
        Livro book_id = (repository.findById(id_book)
                .orElseThrow(LivroNotFoundException::new));
        if(book_id.getStatus().equals(LivroEnum.EMPRESTADO)){
            livroService.updateStatusBook(book_id.getId_livro());
            return true;
        }
        return false;
    }
}
