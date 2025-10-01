package hotelbooking.usuarios.core.mapper;

import hotelbooking.usuarios.core.dto.CadastroReq;
import hotelbooking.usuarios.core.dto.LoginRes;
import hotelbooking.usuarios.core.model.Login;
import hotelbooking.usuarios.core.model.enums.EUsuario;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class LoginMapper {

    public Login mapear(CadastroReq req) {
        return Login.builder()
                .email(req.email())
                .senha(req.senha())
                .tipo(EUsuario.CLIENTE)
                .build();
    }

    public LoginRes mapear(Login login){
        return LoginRes.builder()
                .id(login.getId())
                .token(UUID.randomUUID())
                .tipo(login.getTipo())
                .build();
    }
}
