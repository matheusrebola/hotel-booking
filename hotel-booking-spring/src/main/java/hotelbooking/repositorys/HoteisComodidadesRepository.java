package hotelbooking.repositorys;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hotelbooking.entities.HoteisComodidades;

@Repository
public interface HoteisComodidadesRepository extends JpaRepository<HoteisComodidades, UUID> {

}
