package hotelbooking.usuarios.core.dto;

import hotelbooking.usuarios.core.model.enums.EUsuario;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class LoginRes {
    private Short id;
    private UUID token;
    private EUsuario tipo;
}
