package br.com.tts.diocidadesapi.controller;

import br.com.tts.diocidadesapi.entity.State;
import br.com.tts.diocidadesapi.exception.NotFoundException;
import br.com.tts.diocidadesapi.service.StateService;
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
@RequestMapping("/states")
public class StateController {

    private final StateService stateService;

    @GetMapping
    public Page<State> findAll(Pageable page) {
        return stateService.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<State> findById(@PathVariable("id") Long id){

        try {
            State state = stateService.findById(id);

            return ResponseEntity.ok(state);

        }catch (NotFoundException notFoundException){
            return ResponseEntity.notFound().build();
        }

    }

}
