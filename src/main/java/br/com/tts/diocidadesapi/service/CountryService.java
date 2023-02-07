package br.com.tts.diocidadesapi.service;

import br.com.tts.diocidadesapi.entity.Country;
import br.com.tts.diocidadesapi.exception.NotFoundException;
import br.com.tts.diocidadesapi.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Tiago Luiz Fernandes
 */

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;
    public Page<Country> findAll(Pageable page) {
        return countryRepository.findAll(page);
    }

    public Country findById(Long id) throws NotFoundException{
        return verifyIfExists(id);
    }

    private Country verifyIfExists(Long id) throws NotFoundException{

        return countryRepository.findById(id).orElseThrow(NotFoundException::new);
    }

}
