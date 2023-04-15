package br.com.fabiofiorita.restapi.service

import br.com.fabiofiorita.restapi.exception.NotFoundException
import br.com.fabiofiorita.restapi.mapper.TopicoFormMapper
import br.com.fabiofiorita.restapi.mapper.TopicoViewMapper
import br.com.fabiofiorita.restapi.model.TopicoTest
import br.com.fabiofiorita.restapi.model.TopicoViewTest
import br.com.fabiofiorita.restapi.repository.TopicoRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import java.util.*

class TopicoServiceTest {
    private val topicos = PageImpl(listOf(TopicoTest.build()))
    private val paginacao: Pageable = mockk()
    private val topicoRepository: TopicoRepository = mockk {
        every { findByCursoNome(any(), any()) } returns topicos
        every { findAll() } returns topicos.toList() //TODO: Arrumar a paginação e retornar a usar como Page<TopicoView>
        every { findById(any()) } returns Optional.empty()
    }
    private val topicoViewMapper: TopicoViewMapper = mockk{
        every { map(any()) } returns TopicoViewTest.build()
    }
    private val topicoFormMapper: TopicoFormMapper = mockk()

    private val topicoService = TopicoService(topicoRepository, topicoViewMapper, topicoFormMapper)

    @Test
    fun `deve listar topicos a partir do nome do curso`() {
        topicoService.listar("nomeCurso", paginacao)

        verify(exactly = 1) { topicoRepository.findByCursoNome(any(), any()) }
        verify(exactly = 0) { topicoRepository.findAll() }
        verify(exactly = 1) { topicoViewMapper.map(any()) }
    }

    @Test
    fun `deve listar todos os topicos quando o nome do curso for nulo`() {
        topicoService.listar(null, paginacao)

        verify(exactly = 0) { topicoRepository.findByCursoNome(any(), any()) }
        verify(exactly = 1) { topicoRepository.findAll() }
        verify(exactly = 1) { topicoViewMapper.map(any()) }
    }

    @Test
    fun `deve listar not found exception quando topico nao for achado`() {
        val atual = assertThrows<NotFoundException> {
            topicoService.buscarPorId(1)
        }
        assertEquals("Topico não encontrado!", atual.message)
        verify(exactly = 1) { topicoRepository.findById(any()) }
    }
}