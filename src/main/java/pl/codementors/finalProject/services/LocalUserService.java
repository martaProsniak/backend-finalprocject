package pl.codementors.finalProject.services;

import pl.codementors.finalProject.models.LocalUser;

import java.util.List;

/**
 * @author Marta
 */
public interface LocalUserService {


    List<LocalUser> findAllUsers();

    LocalUser createUser (LocalUser localUser);

    LocalUser editUser(LocalUser localUser);

    void deleteUser (Long id);

    void activateUser(Long id);

    void deactivateUser (Long id);

    LocalUser findOne(Long id);

    LocalUser addCart(Long userId, Long cartId);
}
