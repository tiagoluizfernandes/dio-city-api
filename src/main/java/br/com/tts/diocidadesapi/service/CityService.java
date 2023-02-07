package br.com.tts.diocidadesapi.service;

import br.com.tts.diocidadesapi.entity.City;
import br.com.tts.diocidadesapi.entity.Country;
import br.com.tts.diocidadesapi.exception.NotFoundException;
import br.com.tts.diocidadesapi.repository.CityRepository;
import br.com.tts.diocidadesapi.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Tiago Luiz Fernandes
 */

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;
    public Page<City> findAll(Pageable page) {
        return cityRepository.findAll(page);
    }

    public City findById(Long id) throws NotFoundException{
        return verifyIfExists(id);
    }

    private City verifyIfExists(Long id) throws NotFoundException{

        return cityRepository.findById(id).orElseThrow(NotFoundException::new);
    }

}
