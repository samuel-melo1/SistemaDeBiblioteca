package com.biblioteca.sistemadebiblioteca.model.service;

import com.biblioteca.sistemadebiblioteca.model.dto.PessoaDTO;
import com.biblioteca.sistemadebiblioteca.model.exceptions.EmailExistsException;
import com.biblioteca.sistemadebiblioteca.model.domain.Pessoa;
import com.biblioteca.sistemadebiblioteca.model.repository.PessoaRepository;
import jakarta.transaction.Transactional;
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
                pessoaDTO.role());

        return pessoaRepository.save(newUser);
    }
    public List<Pessoa> getAll(){
        return pessoaRepository.findAll();
    }
    @Transactional
    public boolean deletePessoa(int id_pessoa){
        Optional<Pessoa> pessoa_id = pessoaRepository.findById(id_pessoa);
        if(pessoa_id.isEmpty()){
            return false;
        }
        pessoaRepository.deleteById(id_pessoa);
        return true;
    }
}
