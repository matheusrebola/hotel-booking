package hotelbooking.dtos;

import java.math.BigDecimal;
import java.util.UUID;

import hotelbooking.entities.Disponibilidade;
import hotelbooking.entities.TipoQuarto;
import jakarta.validation.constraints.NotNull;

public record QuartosDto(
		@NotNull UUID id,
		TipoQuarto tipoQuarto,
		String descricao,
		Integer capacidade,
		BigDecimal precoPorNoite,
		Disponibilidade disponibilidade) {

}
