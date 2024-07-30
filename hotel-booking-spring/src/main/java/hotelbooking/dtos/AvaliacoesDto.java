package hotelbooking.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public record AvaliacoesDto(
		@NotNull UUID id,
		Float nota,
		String comentario,
		LocalDateTime dataAvaliacao) {

}
