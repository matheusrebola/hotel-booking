package hotelbooking.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public record OfertasEspeciais(
		@Id @GeneratedValue(strategy = GenerationType.UUID) UUID id,
		String descricao,
		Float desconto,
		LocalDateTime dataInicio,
		LocalDateTime dataFim) {

}
