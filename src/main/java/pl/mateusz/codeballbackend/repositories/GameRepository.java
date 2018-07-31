package pl.mateusz.codeballbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.mateusz.codeballbackend.model.Game;

import java.time.LocalDateTime;
import java.util.List;

public interface GameRepository extends CrudRepository<Game, Integer> {

    List<Game> findAllByOrderByStartTimeDesc();

}
