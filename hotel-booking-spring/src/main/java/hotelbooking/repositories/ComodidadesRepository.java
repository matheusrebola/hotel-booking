package hotelbooking.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hotelbooking.entities.Comodidades;

@Repository
public interface ComodidadesRepository extends JpaRepository<Comodidades, UUID> {

}
