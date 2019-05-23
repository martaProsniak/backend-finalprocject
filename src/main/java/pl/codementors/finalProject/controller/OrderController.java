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

    @PutMapping(path = "/add")
    public Order addOrder(@PathVariable Long cartId) {
        return orderService.addOrder(cartId);
    }

    /*
    //napisać add order jak niżej

     */



    @DeleteMapping(path = "/{id}")
    public void deleteOrder(@PathVariable Long id) {orderService.deleteOrder(id);}
}
/*
    @RequestMapping(value = "/indexorder", method = RequestMethod.GET)
    public String indexPage(ModelMap modelMap, HttpServletRequest request) {
        modelMap.addAttribute("orderNo", orderDetailService.get(1));
        modelMap.addAttribute("products", productService.list());
        modelMap.addAttribute("customers", customerService.list());
        modelMap.addAttribute("em", request.getParameter("em"));
        return "indexorder";


 */
