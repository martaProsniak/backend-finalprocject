package pl.codementors.finalProject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.codementors.finalProject.models.User;
import pl.codementors.finalProject.repo.UserRepository;

import java.util.List;

/**
 * @author Marta
 * Rest controller for users
 */

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

}
