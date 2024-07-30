package hotelbooking.dtos;

import java.util.UUID;

import hotelbooking.entities.PreferenciasViagem;
import jakarta.validation.constraints.NotNull;

public record UsuarioPreferenciasDto(
		@NotNull UUID id,
		PreferenciasViagem preferencias) {

}
