package pl.codementors.finalProject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.codementors.finalProject.models.Cart;
import pl.codementors.finalProject.models.Order;
import pl.codementors.finalProject.repo.CartRepository;
import pl.codementors.finalProject.repo.LocalUserRepository;
import pl.codementors.finalProject.repo.OrderRepository;
import pl.codementors.finalProject.repo.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class OrderServiceImpl implements OrderService {



    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    private LocalUserRepository localUserRepository;

    private Order order;


    @Override
    public Order getOrder(Long id) {
        return orderRepository.findOne(id);
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> orders =  StreamSupport.stream(orderRepository.findAll().spliterator(),false).collect(Collectors.toList());
        return orders;
    }

    @Override
    public Order addOrder(Long id, String address) {
        Order order = new Order();
        order.setCart(cartRepository.findOne(id));
        order.setOrderTotalPrice(order.getCart().getCartValue());
        order.setLogin(order.getCart().getBuyer().getLogin());
        order.setAddress(address);
        orderRepository.save(order);
        return order;
    }

    @Override
    public void deleteOrder (Long id) {
        orderRepository.delete(id);
    }


    public OrderServiceImpl() {
    }

    @Override
    public Order addCartToOrder(Long cartId, Long orderId) {
        return null;
    }
    /*
    @Override
    public Order addCartToOrder(Long cartId, Long orderId) {
        Order order = new Order();
        Cart cart = cartRepository.findOne(cartId);
        cart.setOrder(order);
        orderRepository.save(order);
        return order;
    }


 */


}
