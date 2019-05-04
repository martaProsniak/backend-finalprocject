package pl.codementors.finalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.codementors.finalProject.models.User;
import pl.codementors.finalProject.services.UserService;

import java.util.List;

/**
 * @author Marta
 * Rest controller for users
 */

@RestController
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value={"", "/", "/home"})
    public String greet(){
        return "Welcome to our store!";
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.findAll();
    }

}
