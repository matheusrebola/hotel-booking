package hotelbooking.repositorys;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hotelbooking.entities.Usuarios;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, UUID> {

}
