package hotelbooking.hoteis.core.controller;

import hotelbooking.hoteis.core.dto.HoteisRes;
import hotelbooking.hoteis.core.mapper.HotelMapper;
import hotelbooking.hoteis.core.model.Hotel;
import hotelbooking.hoteis.core.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/hoteis")
@RequiredArgsConstructor
public class HotelController {
    private final HotelService hotelService;
    private final HotelMapper hotelMapper;

    @GetMapping
    public ResponseEntity<List<HoteisRes>> listarHoteis(){
        List<Hotel> hoteis = hotelService.encontrarTodos();
        List<HoteisRes> res = hotelMapper.construirHoteisRes(hoteis);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
