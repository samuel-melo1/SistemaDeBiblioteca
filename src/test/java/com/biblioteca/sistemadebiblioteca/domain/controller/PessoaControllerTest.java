package com.biblioteca.sistemadebiblioteca.domain.controller;

import com.biblioteca.sistemadebiblioteca.config.token.TokenService;
import com.biblioteca.sistemadebiblioteca.domain.Enums.PessoaRole;
import com.biblioteca.sistemadebiblioteca.domain.dto.AuthenticationDTO;
import com.biblioteca.sistemadebiblioteca.domain.dto.PessoaDTO;
import com.biblioteca.sistemadebiblioteca.domain.model.Pessoa;
import com.biblioteca.sistemadebiblioteca.domain.service.CategoriaService;
import com.biblioteca.sistemadebiblioteca.domain.service.EmprestimoService;
import com.biblioteca.sistemadebiblioteca.domain.service.LivroService;
import com.biblioteca.sistemadebiblioteca.domain.service.PessoaService;
import com.biblioteca.sistemadebiblioteca.repository.PessoaRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.time.LocalDate;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.jwt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.web.servlet.function.RequestPredicates.contentType;

@WebMvcTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration
class PessoaControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private PessoaDTO pessoaDTO;
    @BeforeEach
    public void setup() {
         pessoaDTO =  new PessoaDTO("Samuel", "12256131912",
                LocalDate.of(2004, 12, 20),
                "samuel@gmail.com",
                 "senha123",
                PessoaRole.ADMIN,
                "Criciúma");
    }
}