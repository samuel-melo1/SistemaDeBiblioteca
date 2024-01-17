package com.biblioteca.sistemadebiblioteca.service;

import com.biblioteca.sistemadebiblioteca.config.db.repository.PessoaRepository;
import com.biblioteca.sistemadebiblioteca.config.infra.exceptions.pessoaException.PessoaEmailException;
import com.biblioteca.sistemadebiblioteca.config.infra.exceptions.pessoaException.PessoaNotFoundException;
import com.biblioteca.sistemadebiblioteca.domain.model.Enums.PessoaRole;
import com.biblioteca.sistemadebiblioteca.domain.model.dto.PessoaDTO;
import com.biblioteca.sistemadebiblioteca.domain.model.entity.Pessoa;
import com.biblioteca.sistemadebiblioteca.domain.service.PessoaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class PessoaServiceTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @InjectMocks
    private PessoaService pessoaService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Should successfully register a new person")
    void registerPersonExceptionFalse() {

        PessoaDTO pessoaDTO = new PessoaDTO("Samuel", "12256131912",
                LocalDate.of(2004, 12, 20),
                "samuel@gmail.com",
                "senha123",
                PessoaRole.ADMIN,
                "Criciúma");

        when(pessoaRepository.existsPessoaByEmail(pessoaDTO.email())).thenReturn(false);

        PessoaDTO newPessoa = new PessoaDTO(pessoaDTO.nome(), pessoaDTO.cpf(), pessoaDTO.data_nascimento(),
                pessoaDTO.email(), pessoaDTO.senha(), pessoaDTO.role(), pessoaDTO.endereco());
        this.pessoaService.register(newPessoa);

        verify(pessoaRepository, times(1)).save(any());
    }

    @Test
    @DisplayName("Should throw Exception when Person is exist")
    public void registerPersonExceptionTrue() {

        PessoaDTO pessoaDTO = new PessoaDTO("Samuel", "12256131912",
                LocalDate.of(2004, 12, 20),
                "samuel@gmail.com",
                "senha123",
                PessoaRole.ADMIN,
                "Criciúma");

        when(pessoaRepository.existsPessoaByEmail(pessoaDTO.email())).thenReturn(true);
        Exception thrown = Assertions.assertThrows(PessoaEmailException.class, () -> {
            PessoaDTO newPessoa = new PessoaDTO(pessoaDTO.nome(), pessoaDTO.cpf(), pessoaDTO.data_nascimento(),
                    pessoaDTO.email(), pessoaDTO.senha(), pessoaDTO.role(), pessoaDTO.endereco());
            this.pessoaService.register(newPessoa);
        });
        Assertions.assertEquals("Email já cadastrado!", thrown.getMessage());

    }

    @Test
    @DisplayName("Should successfully delete a person")
    void deletePessoaWhenPersonIsFounded() {

        Pessoa pessoa = new Pessoa(2, "Samuel", "12256131912", LocalDate.of(2004, 12, 20),
                "Criciúma",
                "samuel@gmail.com",
                "senha123",
                PessoaRole.ADMIN
        );

        when(pessoaRepository.findById(2)).thenReturn(Optional.of(pessoa));
         boolean result = this.pessoaService.deletePessoa(2);

        verify(pessoaRepository, times(1)).deleteById(any());
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Should throw Exception when Person is not exist")
    void deletePessoaWhenPersonIsNotFounded() {

        when(pessoaRepository.findById(2)).thenReturn(Optional.empty());

        Exception thrown = Assertions.assertThrows(PessoaNotFoundException.class, () -> {
            this.pessoaService.deletePessoa(2);
        });

        Assertions.assertEquals("Not found Users!", thrown.getMessage());
    }
}