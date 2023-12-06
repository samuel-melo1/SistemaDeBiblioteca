package com.biblioteca.sistemadebiblioteca.service;

import com.biblioteca.sistemadebiblioteca.dto.LivroDTO;
import com.biblioteca.sistemadebiblioteca.exceptions.LivroException;
import com.biblioteca.sistemadebiblioteca.model.Livro;
import com.biblioteca.sistemadebiblioteca.repository.LivroRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    private LivroRepository repository;
    public LivroService(LivroRepository repository){
        this.repository = repository;
    }

    public Livro createBook(LivroDTO livroDTO) throws LivroException {
        if(repository.existsLivroByTitulo(livroDTO.titulo())){
            throw new LivroException("Livro já cadastrado!");
        }
        Livro newBook = new Livro(livroDTO.titulo(),livroDTO.categoria());
        return repository.save(newBook);
    }
    public List<Livro> getAllBooks(){
        List<Livro> list = repository.findAll();
        if(list.isEmpty()){
            throw new LivroException("Não há nenhum livro cadastrado!");
        }
        return list;
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
