package hotelbooking.hoteis.core.model;

import hotelbooking.hoteis.core.model.enums.EComodidade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "tb_comodidades", schema = "hotelbooking", indexes = {
        @Index(name = "idx_comodidade_comodidade", columnList = "comodidade")
})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Comodidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private EComodidade comodidade;

    @ManyToMany(mappedBy = "comodidades")
    private Set<Hotel> hoteis;
}
