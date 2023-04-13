package br.com.fabiofiorita.restapi.repository

import br.com.fabiofiorita.restapi.model.Curso
import org.springframework.data.jpa.repository.JpaRepository

interface CursoRepository: JpaRepository<Curso, Long> {
}