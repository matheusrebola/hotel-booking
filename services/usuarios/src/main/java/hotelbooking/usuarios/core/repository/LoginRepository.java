package hotelbooking.usuarios.core.repository;

import hotelbooking.usuarios.core.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login,Short> {
    Login findyEmail(String email);
}
