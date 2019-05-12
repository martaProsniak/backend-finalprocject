package pl.codementors.finalProject.controller;

import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.codementors.finalProject.models.Cart;
import pl.codementors.finalProject.models.Product;
import pl.codementors.finalProject.models.User;
import pl.codementors.finalProject.repo.CartRepository;
import pl.codementors.finalProject.repo.ProductRepository;
import pl.codementors.finalProject.repo.UserRepository;
import pl.codementors.finalProject.services.UserService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Marta
 * Rest controller for users
 */

@RestController
public class UserRestController {

    //TODO moove to service
    private User user;
    private Cart cart;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartRepository cartRepository;

    @GetMapping(value={"", "/", "/home"})
    public String greet(){
        return "Welcome to our store!";
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @PutMapping("/users/{userId}/setCart/{cartId}")
    public User addCart(@PathVariable("userId") Long userId, @PathVariable("cartId") Long cartId){
        user = userRepository.findOne(userId);
        cart = cartRepository.findOne(cartId);
        user.setCart(cart);
        userRepository.save(user);
        return user;
    }
}
