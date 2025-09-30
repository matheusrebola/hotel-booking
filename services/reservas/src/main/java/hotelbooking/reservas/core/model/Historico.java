package hotelbooking.reservas.core.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_historico_reservas", schema = "hotel-booking", indexes = {
        @Index(name = "idx_historico_usuario_id", columnList = "usuario_id"),
        @Index(name = "idx_historico_dt_reserva", columnList = "dt_reserva")
})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Historico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dt_reserva", updatable = false)
    private LocalDateTime data;

    @Column(name = "usuario_id")
    private Long usuario;

    @Column(name = "criado_em")
    private LocalDateTime criadoEm;
}
