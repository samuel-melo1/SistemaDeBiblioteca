package com.biblioteca.sistemadebiblioteca.service;

import com.biblioteca.sistemadebiblioteca.exceptions.EmailExistsException;
import com.biblioteca.sistemadebiblioteca.model.Pessoa;
import com.biblioteca.sistemadebiblioteca.repository.PessoaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;
    private PasswordEncoder passwordEncoder;

    public PessoaService(PessoaRepository pessoaRepository, PasswordEncoder passwordEncoder){
        this.pessoaRepository = pessoaRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Pessoa register(Pessoa pessoa) throws EmailExistsException {
        if(pessoaRepository.existsPessoaByEmail(pessoa.getEmail())){
            throw new EmailExistsException("Email já cadastrado!");
        }
        pessoa.setSenha(passwordEncoder.encode(pessoa.getSenha()));
        return pessoaRepository.save(pessoa);
    }


}
