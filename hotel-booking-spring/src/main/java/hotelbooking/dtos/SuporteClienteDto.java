package hotelbooking.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import hotelbooking.entities.StatusSuporte;
import hotelbooking.entities.TipoSuporte;
import jakarta.validation.constraints.NotNull;

public record SuporteClienteDto(
		@NotNull UUID id,
		TipoSuporte tipoSuporte,
		String descricaoProblema,
		LocalDateTime dataSolicitacao,
		StatusSuporte statusSuporte) {

}
