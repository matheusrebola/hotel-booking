package hotelbooking.usuarios.core.mapper;

import hotelbooking.usuarios.core.dto.CadastroReq;
import hotelbooking.usuarios.core.model.Usuario;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UsuarioMapper {

    public Usuario mapear(CadastroReq req) {
        return Usuario.builder()
                .nome(req.nome())
                .email(req.email())
                .telefone(req.telefone())
                .nascimento(req.dataNascimento())
                .preferencias(req.preferencia())
                .criadoEm(LocalDateTime.now())
                .atualizadoEm(LocalDateTime.now())
                .build();
    }
}
