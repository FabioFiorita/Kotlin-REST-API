# API RESTful para um Fórum escrito em Kotlin com Spring Boot 🚀
[![CI](https://github.com/FabioFiorita/Kotlin-REST-API/actions/workflows/CI.yaml/badge.svg)](https://github.com/FabioFiorita/Kotlin-REST-API/actions/workflows/CI.yaml)
[![codebeat badge](https://codebeat.co/badges/0b2ac172-2eae-4798-86e1-6c25f93e8a42)](https://codebeat.co/projects/github-com-fabiofiorita-kotlin-rest-api-master)

![GitHub](https://img.shields.io/github/license/fabiofiorita/Kotlin-REST-API)
![GitHub language count](https://img.shields.io/github/languages/count/fabiofiorita/Kotlin-REST-API)
![GitHub top language](https://img.shields.io/github/languages/top/fabiofiorita/Kotlin-REST-API)

<img src="https://raw.githubusercontent.com/FabioFiorita/Kotlin-REST-API/master/images/swaggerUI.png#vitrinedev" alt="Kotlin REST API">

- [API RESTful para um Fórum escrito em Kotlin com Spring Boot 🚀](#api-restful-para-um-fórum-escrito-em-kotlin-com-spring-boot-)
  - [Descrição 📝](#descrição-)
  - [Instalação 💻](#instalação-)
  - [Tecnologias utilizadas 🛠](#tecnologias-utilizadas-)
  - [Docker 🐳](#docker-)
  - [Testes 🧪](#testes-)
  - [Banco de dados 🗄](#banco-de-dados-)
  - [Redis 📦](#redis-)
  - [Autenticação](#autenticação)
  - [Uso 🔍](#uso-)
  - [Links úteis 📌](#links-úteis-)


## Descrição 📝

Este projeto é uma API RESTful escrita em Kotlin usando o framework Spring Boot. A API simula um fórum e possui os seguintes modelos:

- Curso 📚
- Resposta 💬
- StatusTopico (enum) 📊
- Topico 📋
- Usuario 👤

O código está organizado nas seguintes camadas: 
- Controller
- Service
- Repository
- Model
- DTO
- Config
- Security
- Exception
- Mapper

## Instalação 💻

1. Clone este repositório
2. Abra o projeto em sua IDE de preferência
3. Certifique-se de ter o Maven instalado e configurado em sua máquina
4. Execute o comando `mvn clean install` para compilar o projeto e baixar as dependências necessárias
5. Execute o comando `mvn spring-boot:run` para iniciar a aplicação

## Tecnologias utilizadas 🛠

O projeto utiliza as seguintes tecnologias:

- Spring Boot: framework Java para desenvolvimento de aplicações web
- Kotlin: linguagem de programação
- Jackson: biblioteca para serialização e desserialização JSON
- Flyway: gerenciador de versões do banco de dados
- MySQL: banco de dados relacional
- Spring Security: framework para segurança de aplicações web
- JWT: biblioteca para autenticação baseada em tokens

## Docker 🐳

Para executar o projeto com Docker, execute os seguintes comandos:

- `docker build -t restapi -f Dockerfile .`
- `docker run -p 8080:8080 restapi`

## Testes 🧪

Para executar os testes, execute o comando `mvn test`

## Banco de dados 🗄

Foi utilizado o banco de dados MySQL para armazenar os dados da API. O banco de dados é gerenciado pelo Flyway, que realiza a migração do banco de dados a cada nova versão do projeto.

É possivel utilizar o banco de dados MySQL localmente pelo Docker. Para isso, execute os seguintes comandos:

- `docker pull mysql:8.0.32`
- `docker run -d -p 3306:3306 --name mysql-container -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=restapi mysql:8.0.32`

## Redis 📦

Para utilizar o Cache do Redis, é necessário executar o Redis localmente pelo Docker. Para isso, execute os seguintes comandos:

- `docker pull redis:lastest`
- `docker run -d -p 6379:6379 --name redis redis:lastest`

## Autenticação

A API possui autenticação baseada em tokens. Para acessar os endpoints protegidos, é necessário enviar o token de acesso no header da requisição. Para obter o token de acesso, é necessário enviar uma requisição `POST` para o endpoint `/login` com o seguinte corpo:

```json
{
    "username": "admin@email.com",
    "password": "123456"
}
```

## Uso 🔍

A API possui os seguintes endpoints:

- `GET /swagger-ui/index.html`: Documentação da API pelo Swagger UI
- `GET /login`: Retorna um token de acesso
- `GET /topicos`: Retorna uma lista de tópicos
- `GET /topicos?nomeCurso=...`: Retorna uma lista de tópicos filtrados por nome do curso
- `GET /relatorios`: Retorna um relatório de tópicos
- `GET /topicos/{id}`: Retorna informações sobre um tópico específico
- `POST /topicos`: Cria um novo tópico
- `POST /respostas`: Cria uma nova resposta para um tópico específico
- `PUT /topicos/{id}`: Atualiza informações sobre um tópico específico
- `DELETE /topicos/{id}`: Exclui um tópico específico

## Links úteis 📌

- [Documentação do Postman](https://documenter.getpostman.com/view/23374288/2s93XyUNwA)

- [Coleção do Postman](postman/KotlinRESTAPI-PostmanCollection.json)
