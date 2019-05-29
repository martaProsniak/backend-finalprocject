package pl.codementors.finalProject.services;


import pl.codementors.finalProject.models.Order;


import java.util.List;

public interface OrderService {

    Order getOrder(Long id);
    List<Order> getAllOrders();
    Order addOrder(Long cartId, Order order);
    void deleteOrder(Long id);
    Order addCartToOrder(Long cartId, Long orderId);
}
