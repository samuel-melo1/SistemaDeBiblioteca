package com.biblioteca.sistemadebiblioteca.repository;

import com.biblioteca.sistemadebiblioteca.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

    boolean existsPessoaByEmail(String email);

    UserDetails findByEmail(String email);

    UserDetails findByEmailAndSenha(String email, String senha);
}
