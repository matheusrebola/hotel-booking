package hotelbooking.hoteis.core.model;

import hotelbooking.hoteis.core.model.enums.EDisponibilidade;
import hotelbooking.hoteis.core.model.enums.EQuarto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_quartos", schema = "hotelbooking")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Quarto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 50, name = "tipo_quarto")
    private EQuarto quarto;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Column
    private Byte capacidade;

    @Column(name = "preco_noite", precision = 18, scale = 4)
    private BigDecimal preco;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private EDisponibilidade disponibilidade;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;
}
