package hotelbooking.usuarios.core.dto;

import hotelbooking.usuarios.core.model.enums.EPreferencias;

import java.time.LocalDate;

public record CadastroReq
        (String nome,
         String email,
         String senha,
         String telefone,
         LocalDate dataNascimento,
         EPreferencias preferencia) {
}
