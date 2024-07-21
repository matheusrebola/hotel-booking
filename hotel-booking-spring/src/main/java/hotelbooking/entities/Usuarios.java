package hotelbooking.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public record Usuarios(
		@Id @GeneratedValue(strategy = GenerationType.UUID) UUID id,
		String nome,
		String email,
		String senha,
		String telefone,
		LocalDate dataNascimento,
		PreferenciasViagem preferencias,
		LocalDateTime dataCriacao) {

}
