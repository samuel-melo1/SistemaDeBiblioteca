package com.biblioteca.sistemadebiblioteca.domain.service;

import com.biblioteca.sistemadebiblioteca.domain.interfaces.PessoaServiceImpl;
import com.biblioteca.sistemadebiblioteca.domain.model.Pessoa;
import com.biblioteca.sistemadebiblioteca.domain.dto.PessoaDTO;
import com.biblioteca.sistemadebiblioteca.repository.PessoaRepository;
import com.biblioteca.sistemadebiblioteca.config.infra.exceptions.pessoaException.PessoaEmailException;
import com.biblioteca.sistemadebiblioteca.config.infra.exceptions.pessoaException.PessoaNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService implements PessoaServiceImpl {
    private PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;

    }
    @Override
    public Pessoa register(PessoaDTO pessoaDTO) throws PessoaEmailException {
        if (pessoaRepository.existsPessoaByEmail(pessoaDTO.email())) {
            throw new PessoaEmailException();
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(pessoaDTO.senha());

        Pessoa newUser = new Pessoa(pessoaDTO.nome(), pessoaDTO.cpf(), pessoaDTO.data_nascimento(), pessoaDTO.endereco(),
                pessoaDTO.email(),
                encryptedPassword,
                pessoaDTO.role());

        return pessoaRepository.save(newUser);
    }

    @Override
    public List<Pessoa> getAll() {
        return pessoaRepository.findAll();
    }

    @Override
    @Transactional
    public boolean deletePessoa(int id_pessoa) {
        Pessoa pessoa_id = pessoaRepository.findById(id_pessoa)
                .orElseThrow(PessoaNotFoundException::new);

        pessoaRepository.deleteById(id_pessoa);
        return true;
    }
}
