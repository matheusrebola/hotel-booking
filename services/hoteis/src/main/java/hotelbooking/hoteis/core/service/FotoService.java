package hotelbooking.hoteis.core.service;

import hotelbooking.hoteis.core.model.Foto;
import hotelbooking.hoteis.core.repository.FotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FotoService {
    private final FotoRepository repository;

    public List<Foto> encontrarTodos() {
        return repository.findAll();
    }
}
