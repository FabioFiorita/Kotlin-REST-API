package br.com.fabiofiorita.restapi.integration

import br.com.fabiofiorita.restapi.configuration.DatabaseContainerConfiguration
import br.com.fabiofiorita.restapi.dto.TopicoPorCategoriaDto
import br.com.fabiofiorita.restapi.model.TopicoTest
import br.com.fabiofiorita.restapi.repository.TopicoRepository
import org.junit.Assert
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.data.domain.PageRequest
import org.testcontainers.junit.jupiter.Testcontainers

@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TopicoRepositoryTest: DatabaseContainerConfiguration() {

    @Autowired lateinit var topicoRepository: TopicoRepository

    private val topico = TopicoTest.build()


    @BeforeEach
    fun before() {
        topicoRepository.save(topico)
    }

    @Test
    fun `deve gerar um relatorio`() {
        val relatorio = topicoRepository.relatorio()

        assert(relatorio.isNotEmpty())
        Assertions.assertEquals(TopicoPorCategoriaDto::class, relatorio.first()::class)

    }

    @Test
    fun `deve listar topicos a partir do nome do curso`() {
        val topico = topicoRepository.findByCursoNome(topico.curso.nome, PageRequest.of(0, 5))
        Assert.assertNotNull(topico)
    }

    @Test
    fun `deve listar todos os topicos quando o nome do curso for nulo`() {
        val topico = topicoRepository.findAll()
        Assert.assertNotNull(topico)
    }
}