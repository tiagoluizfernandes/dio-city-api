package br.com.tts.diocidadesapi.controller;

import br.com.tts.diocidadesapi.exception.NotFoundException;
import br.com.tts.diocidadesapi.service.CountryService;
import br.com.tts.diocidadesapi.entity.Country;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Tiago Luiz Fernandes
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/countries")
public class CountryController {

    private final CountryService countryService;

    @GetMapping
    public Page<Country> findAll(Pageable page) {
        return countryService.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> findById(@PathVariable("id") Long id){

        try {
            Country country = countryService.findById(id);

            return ResponseEntity.ok(country);

        }catch (NotFoundException notFoundException){
            return ResponseEntity.notFound().build();
        }

    }

}
