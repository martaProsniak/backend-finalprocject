package pl.codementors.finalProject.services;


import pl.codementors.finalProject.models.Order;


import java.util.List;
import java.util.Optional;

public interface OrderService {

    Order getOrder(Long id);
    List<Order> getAllOrders();
    Order addOrder(Long cartId, Order order);
    void deleteOrder(Long id);
    List<Order> findByBuyer(Long id);
}
