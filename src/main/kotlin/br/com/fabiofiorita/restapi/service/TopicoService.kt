package br.com.fabiofiorita.restapi.service

import br.com.fabiofiorita.restapi.dto.AutalizacaoTopicoForm
import br.com.fabiofiorita.restapi.dto.TopicoForm
import br.com.fabiofiorita.restapi.dto.TopicoPorCategoriaDto
import br.com.fabiofiorita.restapi.dto.TopicoView
import br.com.fabiofiorita.restapi.exception.NotFoundException
import br.com.fabiofiorita.restapi.mapper.TopicoFormMapper
import br.com.fabiofiorita.restapi.mapper.TopicoViewMapper
import br.com.fabiofiorita.restapi.repository.TopicoRepository
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class TopicoService(
    private val repository: TopicoRepository,
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper,
    private val notFoundMessage: String = "Topico não encontrado!"
) {
    fun listar(nomeCurso: String?, paginacao: Pageable): List<TopicoView> { //TODO: Arrumar a paginação, voltar para Page<TopicoView>
        val topicos = if (nomeCurso == null) {
            //TODO: Arrumar a paginação
            //repository.findAll(paginacao)
            repository.findAll()
        } else {
            repository.findByCursoNome(nomeCurso, paginacao)
        }
        return topicos.map { t ->
            topicoViewMapper.map(t)
        }
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = repository.findById(id).orElseThrow { NotFoundException(notFoundMessage) }
        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: TopicoForm): TopicoView {
        val topico = topicoFormMapper.map(form)
        repository.save(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AutalizacaoTopicoForm): TopicoView {
        val topico = repository.findById(form.id).orElseThrow { NotFoundException(notFoundMessage) }
        topico.titulo = form.titulo
        topico.mensagem = form.mensagem
        topico.dataAlteracao = LocalDate.now()
        return topicoViewMapper.map(topico)
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }

    fun relatorio(): List<TopicoPorCategoriaDto> {
        return repository.relatorio()
    }
}