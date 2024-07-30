package hotelbooking.dtos;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public record HoteisLocalizacaoDto(
		@NotNull UUID id,
		String nome,
		String descricao,
		String endereco,
		String cidade,
		String estado,
		String pais,
		String cep,
		String latitude,
		String longitude) {

}
