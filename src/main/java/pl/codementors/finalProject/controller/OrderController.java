package pl.codementors.finalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.codementors.finalProject.models.Order;
import pl.codementors.finalProject.services.OrderService;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping(path = "/{id")
    public Order getOrder(@PathVariable Long id) {
        return orderService.getOrder(id);
    }

    @GetMapping(path = "/")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping(path = "/")
    public Order saveOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteOrder(@PathVariable Long id) {orderService.deleteOrder(id);}
}
