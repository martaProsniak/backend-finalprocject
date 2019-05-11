package pl.codementors.finalProject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.codementors.finalProject.models.User;
import pl.codementors.finalProject.repo.UserRepository;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {

        return (List<User>) userRepository.findAll();
    }

    @Override
    public User createUser (User user) {
        return userRepository.save(user);
    }

    @Override
    public User edit(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser (Long id) {
        userRepository.delete(id);
    }

    @Override
    public void activate(Long id) {
        userRepository.findOne(id).setAccepted(true);
        userRepository.save(userRepository.findOne(id));
    }

    @Override
    public User findOne(Long id) {
        return userRepository.findOne(id);
    }
}
