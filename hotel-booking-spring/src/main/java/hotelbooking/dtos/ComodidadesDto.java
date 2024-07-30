package hotelbooking.dtos;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public record ComodidadesDto(
		@NotNull UUID id,
		String nome,
		String descricao) {

}
