package hotelbooking.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import hotelbooking.entities.PreferenciasViagem;

public record UsuariosCreateDto(
		String nome,
		String email,
		String senha,
		String telefone,
		LocalDate dataNascimento,
		PreferenciasViagem preferencias,
		LocalDateTime dataCriacao) {

}
