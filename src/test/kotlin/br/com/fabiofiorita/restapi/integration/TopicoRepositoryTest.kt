package br.com.fabiofiorita.restapi.integration

import br.com.fabiofiorita.restapi.dto.TopicoPorCategoriaDto
import br.com.fabiofiorita.restapi.model.TopicoTest
import br.com.fabiofiorita.restapi.repository.TopicoRepository
import org.junit.Assert
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.domain.PageRequest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.MySQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TopicoRepositoryTest {

    @Autowired lateinit var topicoRepository: TopicoRepository

    private val topico = TopicoTest.build()

    companion object {
        @Container
        private val mySQLContainer = MySQLContainer<Nothing>("mysql:8.0.32").apply {
            withDatabaseName("testdb")
            withUsername("testuser")
            withPassword("testpass")
        }

        @JvmStatic
        @DynamicPropertySource
        fun properties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", mySQLContainer::getJdbcUrl)
            registry.add("spring.datasource.username", mySQLContainer::getUsername)
            registry.add("spring.datasource.password", mySQLContainer::getPassword)
        }
    }

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