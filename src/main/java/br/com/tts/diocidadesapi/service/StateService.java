package br.com.tts.diocidadesapi.service;

import br.com.tts.diocidadesapi.entity.Country;
import br.com.tts.diocidadesapi.entity.State;
import br.com.tts.diocidadesapi.exception.NotFoundException;
import br.com.tts.diocidadesapi.repository.CountryRepository;
import br.com.tts.diocidadesapi.repository.StateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Tiago Luiz Fernandes
 */

@Service
@RequiredArgsConstructor
public class StateService {

    private final StateRepository stateRepository;
    public Page<State> findAll(Pageable page) {
        return stateRepository.findAll(page);
    }

    public State findById(Long id) throws NotFoundException{
        return verifyIfExists(id);
    }

    private State verifyIfExists(Long id) throws NotFoundException{

        return stateRepository.findById(id).orElseThrow(NotFoundException::new);
    }

}
