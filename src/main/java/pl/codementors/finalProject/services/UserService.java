package pl.codementors.finalProject.services;

import pl.codementors.finalProject.models.User;

import java.util.List;

public interface UserService {


    List<User> findAll();

    User create (User user);

    User edit (User user);

    void delete (User user);

    User activate (User user);
}
