package com.biblioteca.sistemadebiblioteca.service;

import com.biblioteca.sistemadebiblioteca.repository.PessoaRepository;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    }


}
