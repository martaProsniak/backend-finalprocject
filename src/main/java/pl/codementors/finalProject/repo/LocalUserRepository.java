package pl.codementors.finalProject.repo;

import pl.codementors.finalProject.models.LocalUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Marta
 */
@Repository
public interface LocalUserRepository extends CrudRepository<LocalUser, Long>{
    List<LocalUser> findAll();
    Optional<LocalUser> findByName(String userName);
    LocalUser findOne(Long id);
}
