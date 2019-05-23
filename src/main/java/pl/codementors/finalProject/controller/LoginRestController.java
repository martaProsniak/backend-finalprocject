package pl.codementors.finalProject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.codementors.finalProject.models.LocalUser;
import pl.codementors.finalProject.models.LoginData;
import pl.codementors.finalProject.repo.LocalUserRepository;
import pl.codementors.finalProject.services.LocalUserService;

import java.util.Optional;

@CrossOrigin
@RestController
public class LoginRestController {

    private LocalUser localUser;

    @Autowired
    private LocalUserService localUserService;

    @Autowired
    private LocalUserRepository localUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping(value= "/login")
    public ResponseEntity<LocalUser> login(@RequestBody LoginData loginData) {
        Optional<LocalUser> found = localUserRepository.findByLogin(loginData.getLogin());
        //jeżeli nieistnieje
        if(!found.isPresent()) {
            return ResponseEntity.notFound().build();
        }else{
            Boolean matches = passwordEncoder.matches(loginData.getPassword(), found.get().getPassword());
            if(matches) {
                return ResponseEntity.ok(found.get());
            }
            return ResponseEntity.badRequest().build();
        }
    }
}