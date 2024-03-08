package com.biblioteca.sistemadebiblioteca.domain.interfaces;

import com.biblioteca.sistemadebiblioteca.domain.dto.PessoaDTO;
import com.biblioteca.sistemadebiblioteca.domain.model.Pessoa;

import java.util.List;

public interface PessoaServiceImpl {

    public Pessoa register(PessoaDTO pessoaDTO);

    public List<Pessoa> getAll();

    public boolean deletePessoa(int id_pessoa);
}
