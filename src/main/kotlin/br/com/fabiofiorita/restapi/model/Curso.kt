package br.com.fabiofiorita.restapi.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
data class Curso(
    @Id @GeneratedValue
    val id: Long? = null,
    val nome: String,
    val categoria: String
)
