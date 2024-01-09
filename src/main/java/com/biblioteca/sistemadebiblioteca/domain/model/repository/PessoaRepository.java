package com.biblioteca.sistemadebiblioteca.domain.model.repository;

import com.biblioteca.sistemadebiblioteca.domain.model.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
    boolean existsPessoaByEmail(String email);
    UserDetails findByEmail(String email);

}
