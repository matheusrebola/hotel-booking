package hotelbooking.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public record HistoricoReservasDto(
		@NotNull UUID id,
		LocalDateTime dataReserva) {

}
