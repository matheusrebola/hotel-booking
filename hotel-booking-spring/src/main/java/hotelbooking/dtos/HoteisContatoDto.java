package hotelbooking.dtos;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public record HoteisContatoDto(
		@NotNull UUID id,
		String telefone,
		String email,
		String website) {

}
