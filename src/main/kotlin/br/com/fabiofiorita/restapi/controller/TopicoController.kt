package br.com.fabiofiorita.restapi.controller

import br.com.fabiofiorita.restapi.dto.TopicoForm
import br.com.fabiofiorita.restapi.dto.TopicoView
import br.com.fabiofiorita.restapi.service.TopicoService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/topicos")
class TopicoController(private val service: TopicoService) {
    @GetMapping
    fun listar(): List<TopicoView> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): TopicoView {
        return service.buscarPorId(id = id)
    }

    @PostMapping
    fun cadastrar(@RequestBody @Valid form: TopicoForm) {
        service.cadastrar(form = form)
    }
}