package hotelbooking.dtos;

import java.math.BigDecimal;

import hotelbooking.entities.Disponibilidade;
import hotelbooking.entities.TipoQuarto;

public record QuartosCreateDto(
		TipoQuarto tipoQuarto,
		String descricao,
		Integer capacidade,
		BigDecimal precoPorNoite,
		Disponibilidade disponibilidade) {

}
