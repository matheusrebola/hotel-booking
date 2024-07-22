package hotelbooking.repositorys;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hotelbooking.entities.Quartos;

@Repository
public interface QuartosRepository extends JpaRepository<Quartos, UUID> {

}
