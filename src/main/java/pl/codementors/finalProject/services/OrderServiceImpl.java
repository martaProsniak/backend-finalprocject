package pl.codementors.finalProject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.codementors.finalProject.Exceptions.ResourceNotFoundException;
import pl.codementors.finalProject.models.Cart;
import pl.codementors.finalProject.models.Order;
import pl.codementors.finalProject.repo.OrderRepository;
import pl.codementors.finalProject.repo.ProductRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

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
    public Order addOrder(Order order) throws ResourceNotFoundException {
        try {
            order.getCartList().stream().forEach(x->updateCart(x));
            order.calculateOrderTotalPrice();
            order.setOrderDate(new Date());
            return orderRepository.save(order);
        }catch (Exception e) {
            e.printStackTrace();
            throw new ResourceNotFoundException("Order is not saved. Check your data.");
        }

    }

    @Override
    public void deleteOrder(Long id) {

    }

    @Override
    public void updateCart(Cart x) {

    }

    public OrderServiceImpl() {
    }
}
