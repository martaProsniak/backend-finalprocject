package pl.codementors.finalProject.repo;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.codementors.finalProject.models.LocalUser;
import pl.codementors.finalProject.models.Order;

import java.util.List;
import java.util.Optional;


@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findOrderByBuyer (LocalUser buyer);
}
