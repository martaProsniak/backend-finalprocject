package pl.codementors.finalProject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.codementors.finalProject.models.Product;
import pl.codementors.finalProject.models.User;
import pl.codementors.finalProject.services.ProductService;
import pl.codementors.finalProject.services.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marta
 * Rest controller for users
 */

@RestController
@CrossOrigin
public class UserRestController {

    private UserService userService;


    private ProductService productService;

    @Autowired
    public UserRestController(UserService userService, ProductService productService){
        this.userService = userService;
        this.productService = productService;
    }

    @GetMapping(value={"", "/", "/home"})
    public String greet(){
        return "Welcome to our store!";
    }

    @GetMapping("/users/")
    public List<User> getUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUserById (@PathVariable Long id) {
        return userService.findOne(id);
    }

    @PostMapping("/users/add")
    @ResponseStatus(HttpStatus.CREATED)
    public User create (@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/users/delete/{id}")
    public void remove (@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PostMapping("/users/edit/{id}")
    public User edit (@RequestBody User user) {
        return userService.editUser(user);
    }

    @PostMapping("/users/activate/{id}")
    public void activate (@PathVariable Long id) {
      userService.activateUser(id);
    }

    @PostMapping("/users/deactivate/{id}")
    public void deactivate (@PathVariable Long id) {
        userService.deactivateUser(id);
    }

    @PutMapping("/users/{userId}/setCart/{cartId}")
    public User addCart(@PathVariable("userId") Long userId, @PathVariable("cartId") Long cartId){
       return userService.addCart(userId, cartId);
    }
}
