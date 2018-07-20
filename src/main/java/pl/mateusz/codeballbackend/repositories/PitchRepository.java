package pl.mateusz.codeballbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.mateusz.codeballbackend.model.Pitch;

public interface PitchRepository extends CrudRepository<Pitch, Integer> {
}
