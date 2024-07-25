package hotelbooking.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hotelbooking.entities.HistoricoReservas;

@Repository
public interface HistoricoReservasRepository extends JpaRepository<HistoricoReservas, UUID> {

}
