package hotelbooking.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hotelbooking.entities.SuporteCliente;

@Repository
public interface SuporteClienteRepository extends JpaRepository<SuporteCliente, UUID> {

}
