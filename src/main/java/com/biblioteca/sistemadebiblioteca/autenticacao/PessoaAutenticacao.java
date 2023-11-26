package com.biblioteca.sistemadebiblioteca.autenticacao;

import com.biblioteca.sistemadebiblioteca.repository.PessoaRepository;
import org.springframework.stereotype.Service;

@Service
public class PessoaAutenticacao {
    private PessoaRepository pessoaRepository;

    public PessoaAutenticacao(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    }


}
