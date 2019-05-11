package pl.codementors.finalProject.repo;

import org.springframework.data.repository.CrudRepository;
import pl.codementors.finalProject.models.Cart;

import java.util.List;

public interface CartRepository extends CrudRepository<Cart, Long> {
    List<Cart> findAll();
}
