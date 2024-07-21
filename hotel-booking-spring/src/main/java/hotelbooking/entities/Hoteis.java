package hotelbooking.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public record Hoteis(
		@Id @GeneratedValue(strategy = GenerationType.UUID) UUID id,
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
