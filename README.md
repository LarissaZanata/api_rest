# API Cadastro de Pessoa
### Tecnologias Utilizadas

- [x] Java 8
- [x] Spring Boot
- [x] Banco de Dados MySQL
- [x] Swagger 2
- [x] JUnit5

### Rotas Implementadas

| Verbo  | Rota              | Descrição                               |
|--------|-------------------|-----------------------------------------|
| POST   | /api/cadastro     | Salva o cadastro de uma pessoa.         |
| PUT    | /api/cadastro     | Atualiza o cadastro de uma pessoa.      |
| GET    | /api/cadastros    | Retorna uma lista paginada de cadastros.| 
| GET    | /api/cadastro/{id}| Retorna um cadastro unico.              |
| DELETE | /api/cadastro     | Deleta o cadastro de uma pessoa.        |


### Exemplo URL local: 
- Para testar com Swagger: http://localhost:8080/swagger-ui.html
- Para testar via Postman: http://localhost:8080/api/cadastros
