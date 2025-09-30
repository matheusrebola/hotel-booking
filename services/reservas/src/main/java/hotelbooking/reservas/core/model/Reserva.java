package hotelbooking.reservas.core.model;

import hotelbooking.reservas.core.model.enums.EReserva;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_reservas", schema = "hotel-booking", indexes = {
        @Index(name = "idx_reserva_dt_checkin", columnList = "dt_checkin"),
        @Index(name = "idx_reserva_qnt_quartos", columnList = "qnt_quartos"),
        @Index(name = "idx_reserva_status_reserva", columnList = "status_reserva")
})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dt_checkin")
    private LocalDateTime checkin;

    @Column(name = "dt_checkout")
    private LocalDateTime checkout;

    @Column(name = "qnt_quartos")
    private Byte quartos;

    @Column(name = "qnt_hospedes")
    private Byte hospedes;

    @Column(name = "vl_total")
    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_reserva")
    private EReserva reserva;

    @Column(name = "criado_em")
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEm;
}
