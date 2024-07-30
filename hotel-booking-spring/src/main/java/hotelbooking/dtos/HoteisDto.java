package hotelbooking.dtos;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public record HoteisDto(
		@NotNull UUID id,
		String nome,
		String descricao,
		String endereco,
		String cidade,
		String estado,
		String pais,
		String cep,
		String latitude,
		String longitude,
		String telefone,
		String email,
		String website) {

}
