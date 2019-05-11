package pl.codementors.finalProject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.codementors.finalProject.models.Cart;
import pl.codementors.finalProject.models.Product;
import pl.codementors.finalProject.models.User;
import pl.codementors.finalProject.repo.CartRepository;
import pl.codementors.finalProject.services.ProductService;
import pl.codementors.finalProject.services.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marta
 * Rest controller for users
 */

@RestController
public class UserRestController {

    private Cart cart;

    //TODO try to move field to service
    private List<Product> products = new ArrayList<>();

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CartRepository cartRepository;

    @GetMapping(value={"", "/", "/home"})
    public String greet(){
        return "Welcome to our store!";
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUserById (@PathVariable Long id) {
        return userService.findOne(id);
    }

    @PostMapping("/users/add")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser (@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/users/delete/{id}")
    public void removeUser (@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PostMapping("/users/edit/{id}")
    public User editUser (@RequestBody User user) {
        return userService.edit(user);
    }

    @PostMapping("/users/activate/{id}")
    public void editUser (@PathVariable Long id) {
      userService.activate(id);
    }


/*
    @PutMapping("/users/{userId}/setCart/{cartId}")
    public User addCart(@PathVariable("userId") Long userId, @PathVariable("cartId") Long cartId){

        user = userService.findOne(userId);
        cart = cartRepository.findOne(cartId);
        user.setCart(cart);
        userService.save(user);
        return user;
    }*/
}
