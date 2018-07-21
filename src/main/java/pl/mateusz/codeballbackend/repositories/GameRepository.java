package pl.mateusz.codeballbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.mateusz.codeballbackend.model.Game;

public interface GameRepository extends CrudRepository<Game, Integer> {
}
