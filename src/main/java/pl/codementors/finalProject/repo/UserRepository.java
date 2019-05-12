package pl.codementors.finalProject.repo;

import pl.codementors.finalProject.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Marta
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll();
}