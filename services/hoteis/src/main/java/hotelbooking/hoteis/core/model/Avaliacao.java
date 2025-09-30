package hotelbooking.hoteis.core.model;

import hotelbooking.hoteis.core.model.enums.EAvaliacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_avaliacoes", schema = "hotelbooking", indexes = {
        @Index(name = "idx_avaliacao_nota", columnList = "nota")
})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 2, nullable = false)
    private EAvaliacao nota;

    @Column(columnDefinition = "TEXT")
    private String comentario;

    @Column(name = "dt_avaliacao", nullable = false, updatable = false)
    private LocalDateTime avaliacao;

    @Column(name = "hotel_id", nullable = false, updatable = false)
    private Long hotel;

    @Column(name = "usuario_id", nullable = false, updatable = false)
    private Long usuario;
}
