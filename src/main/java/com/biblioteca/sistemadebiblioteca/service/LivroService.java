package com.biblioteca.sistemadebiblioteca.service;

import com.biblioteca.sistemadebiblioteca.dto.LivroDTO;
import com.biblioteca.sistemadebiblioteca.exceptions.LivroExistsException;
import com.biblioteca.sistemadebiblioteca.model.Livro;
import com.biblioteca.sistemadebiblioteca.model.Pessoa;
import com.biblioteca.sistemadebiblioteca.repository.LivroRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LivroService {

    private LivroRepository repository;

    public LivroService(LivroRepository repository){
        this.repository = repository;
    }

    public Livro createBook(LivroDTO livroDTO) throws  LivroExistsException{
        if(repository.existsLivroByTitulo(livroDTO.titulo())){
            throw new LivroExistsException("Livro já cadastrado!");
        }
        Livro newBook = new Livro(livroDTO.titulo(),livroDTO.categoria());
        return repository.save(newBook);
    }

    @Transactional
    public boolean deleteBook(int id_book){
        Optional<Livro> livro_id = repository.findById(id_book);
        if(livro_id.isEmpty()){
            return false;
        }
        repository.deleteById(id_book);
        return true;
    }

}
