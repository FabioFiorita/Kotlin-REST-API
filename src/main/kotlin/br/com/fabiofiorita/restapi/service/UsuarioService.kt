package br.com.fabiofiorita.restapi.service

import br.com.fabiofiorita.restapi.model.Usuario
import br.com.fabiofiorita.restapi.repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class UsuarioService(private val repository: UsuarioRepository) {
    fun buscarPorId(id: Long): Usuario {
        return repository.getReferenceById(id)
    }
}
