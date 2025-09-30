package hotelbooking.hoteis.core.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tb_ofertas", schema = "hotelbooking")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Oferta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Column(precision = 8, scale = 4)
    private BigDecimal desconto;

    @Column(name = "dt_inicio")
    private LocalDate inicio;

    @Column(name = "dt_fim")
    private LocalDate fim;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;
}
