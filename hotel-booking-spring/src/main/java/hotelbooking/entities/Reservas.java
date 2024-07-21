package hotelbooking.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public record Reservas(
		@Id @GeneratedValue(strategy = GenerationType.UUID) UUID id,
		LocalDateTime dataCheckin,
		LocalDateTime dataCheckout,
		Integer numeroQuartos,
		Integer numeroHospedes,
		BigDecimal valorTotal,
		StatusReserva statusReserva) {

}
