package pl.codementors.finalProject.controller;

import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.codementors.finalProject.models.Product;
import pl.codementors.finalProject.models.User;
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

    User user;

    //TODO try to move field to service
    private List<Product> products = new ArrayList<>();

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(value={"", "/", "/home"})
    public String greet(){
        return "Welcome to our store!";
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.findAll();
    }
}
