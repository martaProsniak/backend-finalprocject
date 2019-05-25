package pl.codementors.finalProject.services;


import pl.codementors.finalProject.models.Cart;
import pl.codementors.finalProject.models.Order;


import java.util.List;

public interface OrderService {

    Order getOrder(Long id);
    List<Order> getAllOrders();
    Order addOrder();
    void deleteOrder(Long id);
    void updateCart (Cart x);
    Order addCartToOrder(Long cartId, Long orderId);

}
