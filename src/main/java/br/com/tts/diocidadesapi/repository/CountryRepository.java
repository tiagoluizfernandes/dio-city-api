package br.com.tts.diocidadesapi.repository;

import br.com.tts.diocidadesapi.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Tiago Luiz Fernandes
 */

@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {
}
