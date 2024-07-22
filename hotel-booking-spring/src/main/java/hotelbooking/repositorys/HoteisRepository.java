package hotelbooking.repositorys;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hotelbooking.entities.Hoteis;

@Repository
public interface HoteisRepository extends JpaRepository<Hoteis, UUID> {

}
