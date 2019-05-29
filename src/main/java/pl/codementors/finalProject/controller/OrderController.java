package pl.codementors.finalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.codementors.finalProject.models.Order;
import pl.codementors.finalProject.services.CartService;
import pl.codementors.finalProject.services.OrderService;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    CartService cartService;

    @GetMapping(path = "/{id")
    public Order getOrder(@PathVariable Long id) {
        return orderService.getOrder(id);
    }

    @GetMapping(path = "/")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

   @PostMapping(path = "/add/cart/{id}")
    public Order addOrder(@PathVariable Long id, @RequestBody Order sentOrder) {
        return orderService.addOrder(id, sentOrder);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteOrder(@PathVariable Long id) {orderService.deleteOrder(id);}

}

