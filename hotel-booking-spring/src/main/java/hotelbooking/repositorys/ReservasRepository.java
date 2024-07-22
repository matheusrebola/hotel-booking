package hotelbooking.repositorys;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hotelbooking.entities.Reservas;

@Repository
public interface ReservasRepository extends JpaRepository<Reservas, UUID> {

}
