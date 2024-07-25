package hotelbooking.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hotelbooking.entities.OfertasEspeciais;

@Repository
public interface OfertasEspeciaisRepository extends JpaRepository<OfertasEspeciais, UUID> {

}
