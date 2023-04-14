package br.com.fabiofiorita.restapi.service

import br.com.fabiofiorita.restapi.exception.NotFoundException
import br.com.fabiofiorita.restapi.model.Curso
import br.com.fabiofiorita.restapi.repository.CursoRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class CursoService(
    private val repository: CursoRepository,
    private val notFoundMessage: String = "Curso não encontrado!"
) {
    fun buscarPorId(id: Long): Curso {
        return repository.findByIdOrNull(id) ?: throw NotFoundException(notFoundMessage)
    }
}
