package hotelbooking.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import hotelbooking.entities.PreferenciasViagem;
import jakarta.validation.constraints.NotNull;

public record UsuariosDto(
		@NotNull UUID id,
		String nome,
		String email,
		String senha,
		String telefone,
		LocalDate dataNascimento,
		PreferenciasViagem preferencias,
		LocalDateTime dataCriacao) {

}
