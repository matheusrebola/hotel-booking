package hotelbooking.hoteis.core.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "tb_hoteis", schema = "hotelbooking")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Column(length = 200, nullable = false)
    private String endereco;

    @Column(length = 200, nullable = false)
    private String cidade;

    @Column(length = 5, nullable = false)
    private String estado;

    @Column(length = 200, nullable = false)
    private String pais;

    @Column(length = 10, nullable = false)
    private String cep;

    @Column(length = 40, unique = true)
    private String telefone;

    @Column(length = 100, unique = true)
    private String email;

    @Column
    private String website;

    @ManyToMany
    @JoinTable(
            name = "hotel_comodidade", // Nome da tabela de junção
            joinColumns = @JoinColumn(name = "hotel_id"), // Coluna que referencia Hotel
            inverseJoinColumns = @JoinColumn(name = "comodidade_id") // Coluna que referencia Comodidade
    )
    private Set<Comodidade> comodidades;

    @OneToMany(mappedBy = "hotel")
    private Set<Foto> fotos;

    @OneToMany(mappedBy = "hotel")
    private Set<Oferta> ofertas;

    @OneToMany(mappedBy = "hotel")
    private Set<Quarto> quartos;

    @OneToMany(mappedBy = "hotel")
    private Set<Avaliacao> avaliacoes;
}
