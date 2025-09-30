package hotelbooking.usuarios.core.repository;

import hotelbooking.usuarios.core.models.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login,Short> {
}
