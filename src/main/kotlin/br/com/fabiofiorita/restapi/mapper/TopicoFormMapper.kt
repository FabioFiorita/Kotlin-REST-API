package br.com.fabiofiorita.restapi.mapper

import br.com.fabiofiorita.restapi.dto.TopicoForm
import br.com.fabiofiorita.restapi.model.Topico
import br.com.fabiofiorita.restapi.service.CursoService
import br.com.fabiofiorita.restapi.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper(
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService
) : Mapper<TopicoForm, Topico> {
    override fun map(t: TopicoForm): Topico {
        return Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.buscarPorId(t.idCurso),
            autor = usuarioService.buscarPorId(t.idAutor),
        )
    }

}
