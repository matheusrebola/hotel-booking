package hotelbooking.dtos;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public record FotosHoteisDto(
		@NotNull UUID id,
		String urlFoto,
		String descricao) {

}
