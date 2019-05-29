package pl.codementors.finalProject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pl.codementors.finalProject.models.LocalUser;
import pl.codementors.finalProject.services.LocalUserService;

import java.security.Principal;
import java.util.List;

/**
 * @author Marta
 * Rest controller for users
 */

@CrossOrigin
@RestController
public class LocalUserRestController {

    @Autowired
    private LocalUserService localUserService;
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
        return localUserService.createUser(userSent, passwordEncoder);
    }

    @PostMapping("/users/delete/{id}")
    public void remove (@PathVariable Long id) {
        localUserService.deleteUser(id);
    }

    @PostMapping("/users/edit/{id}")
    public LocalUser edit (@RequestBody LocalUser localUser,
                           @PathVariable Long id)
    {
        return localUserService.editUser(id, localUser);
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
    public LocalUser addCart(@PathVariable("userId") Long userId,
                             @PathVariable("cartId") Long cartId){
       return localUserService.addCart(userId, cartId);
    }
}