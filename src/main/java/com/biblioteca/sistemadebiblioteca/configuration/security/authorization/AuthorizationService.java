package com.biblioteca.sistemadebiblioteca.configuration.security.authorization;

import com.biblioteca.sistemadebiblioteca.model.repository.PessoaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService implements UserDetailsService {

    private PessoaRepository pessoaRepository;

    public AuthorizationService(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return pessoaRepository.findByEmail(username);
    }
}
