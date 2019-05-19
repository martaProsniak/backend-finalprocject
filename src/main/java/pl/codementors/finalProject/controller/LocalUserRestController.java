package pl.codementors.finalProject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pl.codementors.finalProject.models.Product;
import pl.codementors.finalProject.models.LocalUser;
import pl.codementors.finalProject.security.SecurityConfig;
import pl.codementors.finalProject.services.ProductService;
import pl.codementors.finalProject.services.LocalUserService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marta
 * Rest controller for users
 */

@CrossOrigin
@RestController
public class LocalUserRestController {

    //TODO try to move field to service
    private List<Product> products = new ArrayList<>();

    @Autowired
    private LocalUserService localUserService;

    @Autowired
    private ProductService productService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping(value={"", "/", "/home"})
    public String greet(){
        return "Welcome to our store!";
    }

    @GetMapping("/users")
    public List<LocalUser> getUsers() {
        return localUserService.findAllUsers();
    }

    @GetMapping("/users/{id}")
    public LocalUser getUserById (@PathVariable Long id) {
        return localUserService.findOne(id);
    }

    @PostMapping("/users/add")
    public LocalUser create (@RequestBody LocalUser userSent) {
        LocalUser newUser = new LocalUser();
        newUser.setName(userSent.getName());
        newUser.setSurname(userSent.getSurname());
        newUser.setLogin(userSent.getLogin());
        newUser.setPassword(passwordEncoder.encode(userSent.getPassword()));
        newUser.setAccepted(userSent.getAccepted());
        newUser.setRole(userSent.getRole());
        return localUserService.createUser(newUser);
    }

    @PostMapping("/users/delete/{id}")
    public void remove (@PathVariable Long id) {
        localUserService.deleteUser(id);
    }

    @PostMapping("/users/edit/{id}")
    public LocalUser edit (@RequestBody LocalUser localUser) {
        return localUserService.editUser(localUser);
    }

    @PostMapping("/users/activate/{id}")
    public void activate (@PathVariable Long id) {
      localUserService.activateUser(id);
    }

    @PostMapping("/users/deactivate/{id}")
    public void deactivate (@PathVariable Long id) {
        localUserService.deactivateUser(id);
    }

    @PutMapping("/users/{userId}/setCart/{cartId}")
    public LocalUser addCart(@PathVariable("userId") Long userId, @PathVariable("cartId") Long cartId){
       return localUserService.addCart(userId, cartId);
    }
}
