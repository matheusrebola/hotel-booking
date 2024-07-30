package hotelbooking.dtos;

import hotelbooking.entities.Comodidades;
import hotelbooking.entities.Hoteis;

public record HoteisComodidadesDto(
		Comodidades comodidades,
		Hoteis hoteis) {

}
