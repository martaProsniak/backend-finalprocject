package pl.codementors.finalProject.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import pl.codementors.finalProject.models.LocalUser;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

/**
 * @author Marta
 */
public interface LocalUserService {

    List<LocalUser> findAllUsers();
    LocalUser createUser (LocalUser localUser, PasswordEncoder passwordEncoder);
    LocalUser editUser(LocalUser localUser,Long id, Principal principal) throws Exception;
    void deleteUser (Long id);
    void activateUser(Long id);
    void deactivateUser (Long id);
    LocalUser findOne(Long id);
    LocalUser addCart(Long userId, Long cartId);
    Optional<LocalUser> findByName(String userName);
}
