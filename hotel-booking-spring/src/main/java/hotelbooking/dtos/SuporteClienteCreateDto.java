package hotelbooking.dtos;

import java.time.LocalDateTime;

import hotelbooking.entities.StatusSuporte;
import hotelbooking.entities.TipoSuporte;

public record SuporteClienteCreateDto(
		TipoSuporte tipoSuporte,
		String descricaoProblema,
		LocalDateTime dataSolicitacao,
		StatusSuporte statusSuporte) {

}
