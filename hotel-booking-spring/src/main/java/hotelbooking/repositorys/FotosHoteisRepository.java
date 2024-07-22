package hotelbooking.repositorys;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hotelbooking.entities.FotosHoteis;

@Repository
public interface FotosHoteisRepository extends JpaRepository<FotosHoteis, UUID> {

}
