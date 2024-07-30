package hotelbooking.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import hotelbooking.entities.StatusReserva;
import jakarta.validation.constraints.NotNull;

public record ReservasDto(
		@NotNull UUID id,
		LocalDateTime dataCheckin,
		LocalDateTime dataCheckout,
		Integer numeroQuartos,
		Integer numeroHospedes,
		BigDecimal valorTotal,
		StatusReserva statusReserva) {

}
