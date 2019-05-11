package pl.codementors.finalProject.services;

import pl.codementors.finalProject.models.User;

import java.util.List;

public interface UserService {


    List<User> findAll();

    User createUser (User user);

    User edit (User user);

    void deleteUser (Long id);

    void activate (Long id);

    User findOne(Long id);
}
