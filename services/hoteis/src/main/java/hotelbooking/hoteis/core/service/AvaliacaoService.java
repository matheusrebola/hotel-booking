package hotelbooking.hoteis.core.service;

import hotelbooking.hoteis.core.model.Avaliacao;
import hotelbooking.hoteis.core.repository.AvaliacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AvaliacaoService {
    private final AvaliacaoRepository repository;

    public List<Avaliacao> encontrarPeloIdDoHotel(List<Long> id) {
        return repository.findByHotelIdIn(id);
    }

    public List<Avaliacao> encontrarTodos(){
        return repository.findAll();
    }
}
