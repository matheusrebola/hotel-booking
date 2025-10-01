package hotelbooking.hoteis.core.repository;

import hotelbooking.hoteis.core.model.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto,Long> {
}
