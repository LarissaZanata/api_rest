# API Cadastro de Pessoa
### Tecnologias Utilizadas

- [x] Java 8
- [x] Spring Boot
- [x] Banco de Dados MySQL
- [x] JUnit5
- [x] Swagger 2

### Rotas Implementadas

| Verbo  | Rota              | Descrição                             |
|--------|-------------------|---------------------------------------|
| POST   | /api/cadastro     | Salva o cadastro de uma pessoa.       |
| PUT    | /api/cadastro     | Atualiza o cadastro de uma pessoa.    |
| GET    | /api/cadastros    | Retorna uma lista pagina de cadastros.| 
| GET    | /api/cadastro/{id}| Retorna um cadastro unico.            |
| DELETE | /api/cadastro     | Deleta o cadastro de uma pessoa.      |

### Observações

#### Exemplo URL local: 
- Para testar com Swagger: http://localhost:8080/swagger-ui.html
- Para testar via Postman: http://localhost:8080/api/cadastros
