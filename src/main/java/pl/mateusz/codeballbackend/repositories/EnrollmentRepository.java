package pl.mateusz.codeballbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.mateusz.codeballbackend.model.Enrollment;

public interface EnrollmentRepository extends CrudRepository<Enrollment, Integer> {
}
