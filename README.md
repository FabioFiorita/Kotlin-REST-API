# Modelo de API REST utilizando Kotlin com Spring Boot 🚀

## Descrição 📝

Este projeto é uma API RESTful escrita em Kotlin usando o framework Spring Boot. A API simula um fórum e possui os seguintes modelos:

- Curso 📚
- Resposta 💬
- StatusTopico (enum) 📊
- Topico 📋
- Usuario 👤

O código está organizado nas seguintes camadas: controller, dto, exception, mapper, model e service.

## Instalação 💻

1. Clone este repositório
2. Abra o projeto em sua IDE de preferência
3. Certifique-se de ter o Maven instalado e configurado em sua máquina
4. Execute o comando `mvn clean install` para compilar o projeto e baixar as dependências necessárias
5. Execute o comando `mvn spring-boot:run` para iniciar a aplicação

## Uso 🔍

A API possui os seguintes endpoints:

- `GET /topicos`: Retorna uma lista de tópicos
- `POST /topicos`: Cria um novo tópico
- `GET /topicos/{id}`: Retorna informações sobre um tópico específico
- `PUT /topicos/{id}`: Atualiza informações sobre um tópico específico
- `DELETE /topicos/{id}`: Exclui um tópico específico
