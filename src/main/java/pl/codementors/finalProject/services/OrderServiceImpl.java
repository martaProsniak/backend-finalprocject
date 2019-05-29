package pl.codementors.finalProject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.codementors.finalProject.models.Cart;
import pl.codementors.finalProject.models.Order;
import pl.codementors.finalProject.models.Product;
import pl.codementors.finalProject.repo.CartRepository;
import pl.codementors.finalProject.repo.LocalUserRepository;
import pl.codementors.finalProject.repo.OrderRepository;

import java.util.ArrayList;
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
    public Order addOrder(Long cartid, Order sentOrder) {
        Order order = new Order();
        Cart cart = cartRepository.findOne(cartid);
        order.setBuyer(cart.getBuyer());
        order.setValue(cart.getCartValue());
        order.setAddress(sentOrder.getAddress());
        List<Product> itemList = new ArrayList<>(cart.getProducts());
        order.setItems(itemList);
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

}
