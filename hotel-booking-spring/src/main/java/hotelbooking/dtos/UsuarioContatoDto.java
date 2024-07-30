package hotelbooking.dtos;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public record UsuarioContatoDto(
		@NotNull UUID id,
		String nome,
		String email,
		String telefone) {

}
