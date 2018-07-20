package pl.mateusz.codeballbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.mateusz.codeballbackend.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
