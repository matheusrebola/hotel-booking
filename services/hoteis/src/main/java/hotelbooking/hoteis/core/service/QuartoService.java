package hotelbooking.hoteis.core.service;

import hotelbooking.hoteis.core.model.Quarto;
import hotelbooking.hoteis.core.repository.QuartoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuartoService {
    private final QuartoRepository repository;

    public List<Quarto> encontrarTodos() {
        return repository.findAll();
    }
}
