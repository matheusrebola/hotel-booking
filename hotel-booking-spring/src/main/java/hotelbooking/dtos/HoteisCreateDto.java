package hotelbooking.dtos;

public record HoteisCreateDto(
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
