package pl.codementors.finalProject.services;

import pl.codementors.finalProject.models.User;

import java.util.List;

/**
 * @author Marta
 */
public interface UserService {


    List<User> findAllUsers();

    User createUser (User user);

    User editUser(User user);

    void deleteUser (Long id);

    void activateUser(Long id);

    void deactivateUser (Long id);

    User findOne(Long id);

    User addCart(Long userId, Long cartId);
}
