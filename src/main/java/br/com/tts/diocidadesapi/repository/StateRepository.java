package br.com.tts.diocidadesapi.repository;

import br.com.tts.diocidadesapi.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Tiago Luiz Fernandes
 */

@Repository
public interface StateRepository extends JpaRepository<State,Long> {
}
