package hotelbooking.entities;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public record Quartos(
		@Id @GeneratedValue(strategy = GenerationType.UUID) UUID id,
		TipoQuarto tipoQuarto,
		String descricao,
		Integer capacidade,
		BigDecimal precoPorNoite,
		Disponibilidade disponibilidade) {

}
