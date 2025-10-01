package hotelbooking.usuarios.core.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_logins", schema = "autenticacao")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @Column
    private String senha;

    @Column(length = 100, unique = true)
    private String email;

    @Column
    private LocalDateTime ultimoLogin;

    @Column
    private LocalDateTime expiraEm;
}
