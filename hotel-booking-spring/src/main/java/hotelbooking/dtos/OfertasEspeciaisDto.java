package hotelbooking.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public record OfertasEspeciaisDto(
		@NotNull UUID id,
		String descricao,
		Float desconto,
		LocalDateTime dataInicio,
		LocalDateTime dataFim) {

}
