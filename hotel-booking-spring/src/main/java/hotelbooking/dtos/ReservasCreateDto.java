package hotelbooking.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import hotelbooking.entities.StatusReserva;

public record ReservasCreateDto(
		LocalDateTime dataCheckin,
		LocalDateTime dataCheckout,
		Integer numeroQuartos,
		Integer numeroHospedes,
		BigDecimal valorTotal,
		StatusReserva statusReserva) {

}
