package hotelbooking.hoteis.core.repository;

import hotelbooking.hoteis.core.model.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao,Long> {
    List<Avaliacao> findByHotelIdIn(List<Long> ids);
}
