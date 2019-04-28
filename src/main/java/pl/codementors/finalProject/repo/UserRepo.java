package pl.codementors.finalProject.repo;

import pl.codementors.finalProject.models.LocalUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepo extends CrudRepository<LocalUser, String> {
    List<LocalUser> findAll();
}
