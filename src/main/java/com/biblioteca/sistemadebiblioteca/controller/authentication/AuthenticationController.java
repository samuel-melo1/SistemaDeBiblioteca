package com.biblioteca.sistemadebiblioteca.controller.authentication;

import com.biblioteca.sistemadebiblioteca.model.dto.AuthenticationDTO;
import com.biblioteca.sistemadebiblioteca.model.dto.LoginResponseDTO;
import com.biblioteca.sistemadebiblioteca.model.domain.Pessoa;
import com.biblioteca.sistemadebiblioteca.security.configuration.token.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    public AuthenticationController(AuthenticationManager authenticationManager){
        this.authenticationManager = authenticationManager;
    }
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((Pessoa) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

}
