# Biblioteca API

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![MySQL](https://shields.io/badge/MySQL-lightgrey?logo=mysql&style=plastic&logoColor=white&labelColor=blue)

Esse é um projeto construído com  **Java, Spring Boot, Spring JPA, RabbitMQ para Mensageria, Spring Mail, Spring Security e JWT para autenticação STATELESS, jUnit5 e Mockito para testes unitários, MySQL como banco de dados e SWAGGER para documentação. .** 

A API simula um sistema de biblioteca, realizando as operações de empréstimo de um livro, cadastro de um novo livro sendo bibliotecário(ADMIN), exclusão de um livro, envio de email após um empréstimo, entre diversas outras funcionalidades. A API foi desenvolvida para facilitar o empréstimo de livros entre o bibliotecário e o leitor.

## Table of Contents

- [Instalaçao](#instalação)
- [Usabilidade](#usabilidade)
- [API Endpoints](#api-endpoints)
- [Autenticação](#autenticação)
- [Banco de Dados](#banco-de-dados)
- [Contribuição](#contribuição)

## Instalação

1. Clone o repositório:

```bash
git clone https://github.com/samuel-melo1/SistemaDeBiblioteca.git
```

2. Instale as dependencias com Maven

3. Instale [MySQL](https://www.mysql.com/downloads/)
4. Instale  [MySQL Extension](https://dev.mysql.com/doc/mysql-getting-started/en/)

## Usabilidade

1. Inicie a aplicação com o Maven
2. A API estará disponível em http://localhost:8080


## API Endpoints
A API possui os seguintes endpoints:

```markdown

POST /api/v1/register - Rota para registrar um novo usuário

GET /api/v1/listUsers - Rota responsável por listar os usuários cadastrados

DELETE /api/v1/deleteUsers/{id} - Rota para deletar um usuário por id

POST /api/v1/emprestimo/emprestar - Rota para realizar um empréstimo

POST /api/v1/categoria/createCategoria - Rota para criar uma categoria (ADMIN)

GET /api/v1/categoria/getCategorias  - Rota para listar as categorias

POST /api/v1/book/createBook - Rota para criar um livro (ADMIN)

GET /api/v1/book/getBooks - Rota que busca todos os livros

DELETE /api/v1/book/deleteBook/{id} - Rota para exclusão de livro para o ADMIN

POST /api/auth/login -  Rota para login de usuário
```

## Autenticação
A API utiliza o Spring Security e JWT para autenticação. Portanto, segue as roles definidas. 

```
ROLE_USER - Role padrão para usuários comuns .
ROLE_ADMIN - Admin role para adição de livros/pessoas/categorias. 
```
Para acessar os endpoints como um ADMIN ou USER, é necessário realizar a authenticação e inserção da credencial no header. 

## Banco de Dados
O projeto utiliza o [MySQL](https://dev.mysql.com/doc/mysql-getting-started/en/) como banco de dados. O necessário para ser utilizado é apenas criar o banco de dados, as tabelas serão criadas pelo JPA.

## Contribuição

Sugestões e/ou contribuições são bem-vindas! Se você encontrar qualquer questão ou tenha sugestões de melhorias, por favor, abra uma solicitação pull para o repositório. 


Ao contribuir para este projeto, siga o estilo de código existente, [commit conventions](https://www.conventionalcommits.org/en/v1.0.0/), e envie suas alterações em uma ramificação separada.
