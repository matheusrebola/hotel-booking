package hotelbooking.hoteis.core.mapper;

import hotelbooking.hoteis.core.dto.HoteisRes;
import hotelbooking.hoteis.core.model.Foto;
import hotelbooking.hoteis.core.model.Hotel;
import hotelbooking.hoteis.core.model.Quarto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HotelMapper {
    public List<HoteisRes> construirHoteisRes(List<Hotel> hoteis) {
        return hoteis.stream()
                .map(hotel -> {
                    // Calcular média das avaliações
                    Integer notaMedia = calcularNotaMedia(hotel);

                    // Pegar primeiro quarto disponível
                    Quarto quarto = primeiroQuartoDisponivel(hotel);

                    // Pegar primeira foto
                    String fotoUrl = primeiraFoto(hotel);

                    return mapear(hotel, notaMedia, quarto, fotoUrl);
                })
                .collect(Collectors.toList());
    }

    private HoteisRes mapear(Hotel hotel, Integer notaMedia, Quarto quarto, String fotoUrl){
        return HoteisRes.builder()
                .id(hotel.getId())
                .nome(hotel.getNome())
                .cidade(hotel.getCidade())
                .estado(hotel.getEstado())
                .pais(hotel.getPais())
                .nota(notaMedia)
                .quarto(quarto != null ? quarto.getQuarto() : null)
                .capacidade(quarto != null ? quarto.getCapacidade() : null)
                .preco(quarto != null ? quarto.getPreco() : null)
                .foto(fotoUrl)
                .build();
    }

    private Integer calcularNotaMedia(Hotel hotel){
        return hotel.getAvaliacoes() != null && !hotel.getAvaliacoes().isEmpty()
                ? (int) Math.round(hotel.getAvaliacoes().stream()
                .mapToInt(a -> a.getNota().getValor())
                .average()
                .orElse(0.0))
                : null;
    }

    private Quarto primeiroQuartoDisponivel(Hotel hotel){
        return hotel.getQuartos() != null && !hotel.getQuartos().isEmpty()
                ? hotel.getQuartos().stream().findFirst().orElse(null)
                : null;
    }

    private String primeiraFoto(Hotel hotel){
        return hotel.getFotos() != null && !hotel.getFotos().isEmpty()
                ? hotel.getFotos().stream().findFirst().map(Foto::getUrl).orElse(null)
                : null;
    }
}
