package com.biblioteca.sistemadebiblioteca.model.service;

import com.biblioteca.sistemadebiblioteca.model.dto.LivroDTO;
import com.biblioteca.sistemadebiblioteca.model.exceptions.LivroException;
import com.biblioteca.sistemadebiblioteca.model.domain.Livro;
import com.biblioteca.sistemadebiblioteca.model.repository.LivroRepository;
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
        return repository.findAll();
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
