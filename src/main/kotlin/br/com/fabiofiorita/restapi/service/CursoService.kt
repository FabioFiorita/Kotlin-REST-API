package br.com.fabiofiorita.restapi.service

import br.com.fabiofiorita.restapi.model.Curso
import br.com.fabiofiorita.restapi.repository.CursoRepository
import org.springframework.stereotype.Service

@Service
class CursoService(private val repository: CursoRepository) {
    fun buscarPorId(id: Long): Curso {
        return repository.getReferenceById(id)
    }
}
