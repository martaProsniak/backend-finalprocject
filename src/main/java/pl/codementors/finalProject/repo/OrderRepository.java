package pl.codementors.finalProject.repo;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.codementors.finalProject.models.Order;


@Repository
public interface OrderRepository extends CrudRepository <Order, Long> {
}
