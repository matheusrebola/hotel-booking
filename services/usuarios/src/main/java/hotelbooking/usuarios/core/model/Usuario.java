package hotelbooking.usuarios.core.model;

import hotelbooking.usuarios.core.model.enums.EPreferencias;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200)
    private String nome;

    @Column(length = 100, unique = true)
    private String email;

    @Column(length = 20)
    private String telefone;

    @Column(updatable = false)
    private LocalDate nascimento;

    @Enumerated(EnumType.STRING)
    @Column
    private EPreferencias preferencias;

    @Column(updatable = false)
    private LocalDateTime criadoEm;

    @Column
    private LocalDateTime atualizadoEm;
}
