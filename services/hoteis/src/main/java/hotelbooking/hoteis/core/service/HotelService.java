package hotelbooking.hoteis.core.service;

import hotelbooking.hoteis.core.model.Hotel;
import hotelbooking.hoteis.core.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService {
    private final HotelRepository repository;

    public List<Hotel> encontrarTodos() {
        return repository.findAll();
    }

    public List<Long> retornarIdsDosHoteis(List<Hotel> hoteis){
        return hoteis.stream()
                .map(Hotel::getId)
                .toList();
    }
}
