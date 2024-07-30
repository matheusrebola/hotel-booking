package hotelbooking.dtos;

import java.time.LocalDateTime;

public record OfertasEspeciaisCreateDto(
		String descricao,
		Float desconto,
		LocalDateTime dataInicio,
		LocalDateTime dataFim) {

}
