package com.biblioteca.sistemadebiblioteca.service;

import com.biblioteca.sistemadebiblioteca.dto.PessoaDTO;
import com.biblioteca.sistemadebiblioteca.exceptions.EmailExistsException;
import com.biblioteca.sistemadebiblioteca.model.Pessoa;
import com.biblioteca.sistemadebiblioteca.repository.PessoaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    private PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;

    }
    public Pessoa register(PessoaDTO pessoaDTO) throws EmailExistsException {
        if(pessoaRepository.existsPessoaByEmail(pessoaDTO.email())){
            throw new EmailExistsException("Email já cadastrado!");
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(pessoaDTO.senha());

        Pessoa newUser = new Pessoa(pessoaDTO.nome(),
                pessoaDTO.cpf(),
                pessoaDTO.data_nascimento(),
                pessoaDTO.endereco(),
                pessoaDTO.email(),
                encryptedPassword,
                pessoaDTO.role(),
                pessoaDTO.emprestimo());

        return pessoaRepository.save(newUser);
    }

    public List<Pessoa> getAll(){
        return pessoaRepository.findAll();
    }


}
