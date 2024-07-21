package hotelbooking.entities;

import jakarta.persistence.Entity;

@Entity
public record HoteisComodidades(
		Comodidades comodidades,
		Hoteis hoteis) {

}
