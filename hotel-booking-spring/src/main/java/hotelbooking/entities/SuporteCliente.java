package hotelbooking.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public record SuporteCliente(
		@Id @GeneratedValue(strategy = GenerationType.UUID) UUID id,
		TipoSuporte tipoSuporte,
		String descricaoProblema,
		LocalDateTime dataSolicitacao,
		StatusSuporte statusSuporte) {

}
