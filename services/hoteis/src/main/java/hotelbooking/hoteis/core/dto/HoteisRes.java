package hotelbooking.hoteis.core.dto;

import hotelbooking.hoteis.core.model.enums.EQuarto;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class HoteisRes {
    //hoteis
    private Long id;
    private String nome;
    private String cidade;
    private String estado;
    private String pais;
    //avaliacoes
    private Integer nota;
    //quarto
    private EQuarto quarto;
    private Byte capacidade;
    private BigDecimal preco;
    //fotos
    private String foto;
}
