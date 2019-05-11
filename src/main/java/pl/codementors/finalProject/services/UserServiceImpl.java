package pl.codementors.finalProject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import pl.codementors.finalProject.models.User;
import pl.codementors.finalProject.repo.CartRepository;
import pl.codementors.finalProject.repo.UserRepository;


import java.util.List;

/**
 * @author Marta
 * Service to maintain users
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User editUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.delete(id);
    }

    @Override
    public void activateUser(Long id) {
        userRepository.findOne(id).setAccepted(true);
        userRepository.save(userRepository.findOne(id));
    }

    @Override
    public void deactivateUser(Long id) {
        userRepository.findOne(id).setAccepted(false);
        userRepository.save(userRepository.findOne(id));
    }


    @Override
    public User findOne(Long id) {
        return userRepository.findOne(id);
    }

    public User addCart(Long userId, Long cartId) {
        userRepository.findOne(userId).setCart(cartRepository.findOne(cartId));
        return userRepository.save(userRepository.findOne(userId));
    }
}