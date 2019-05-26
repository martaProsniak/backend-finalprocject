package pl.codementors.finalProject.services;


import pl.codementors.finalProject.models.Cart;
import pl.codementors.finalProject.models.Order;


import java.util.List;

public interface OrderService {

    Order getOrder(Long id);
    List<Order> getAllOrders();
    Order addOrder(Long id, String address);
    void deleteOrder(Long id);
    Order addCartToOrder(Long cartId, Long orderId);

}
