package hotelbooking.dtos;

import java.time.LocalDateTime;

public record AvaliacoesCreateDto(
		Float nota,
		String comentario,
		LocalDateTime dataAvaliacao) {

}
