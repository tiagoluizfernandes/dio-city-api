package br.com.tts.diocidadesapi.controller;

import br.com.tts.diocidadesapi.entity.City;
import br.com.tts.diocidadesapi.exception.NotFoundException;
import br.com.tts.diocidadesapi.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tiago Luiz Fernandes
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/cities")
public class CityController {

    private final CityService cityService;

    @GetMapping
    public Page<City> findAll(Pageable page) {
        return cityService.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> findById(@PathVariable("id") Long id){

        try {
            City city = cityService.findById(id);

            return ResponseEntity.ok(city);

        }catch (NotFoundException notFoundException){
            return ResponseEntity.notFound().build();
        }

    }

}
