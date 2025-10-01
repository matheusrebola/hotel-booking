package hotelbooking.hoteis.core.repository;

import hotelbooking.hoteis.core.model.Foto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FotoRepository extends JpaRepository<Foto,Long> {
}
