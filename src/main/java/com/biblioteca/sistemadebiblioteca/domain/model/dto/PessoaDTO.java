package com.biblioteca.sistemadebiblioteca.domain.model.dto;

import com.biblioteca.sistemadebiblioteca.domain.model.Enums.PessoaRole;

import java.time.LocalDate;

public record PessoaDTO(String nome,
                        String cpf,
                        LocalDate data_nascimento,
                        String email,
                        String senha,
                        PessoaRole role,
                        String endereco) {
}
