package pl.codementors.finalProject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.codementors.finalProject.models.LocalUser;
import pl.codementors.finalProject.repo.CartRepository;
import pl.codementors.finalProject.repo.LocalUserRepository;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

/**
 * @author Marta
 * Service to maintain users
 */

@Service
public class LocalUserServiceImpl implements LocalUserService {

    @Autowired
    private LocalUserRepository localUserRepository;
    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<LocalUser> findAllUsers() {
        return localUserRepository.findAll();
    }

    @Override
    public LocalUser createUser(LocalUser userSent,
                                PasswordEncoder passwordEncoder) {

        LocalUser newUser = new LocalUser();

        newUser.setName(userSent.getName());
        newUser.setSurname(userSent.getSurname());
        newUser.setLogin(userSent.getLogin());
        newUser.setPassword(passwordEncoder.encode(userSent.getPassword()));
        newUser.setAccepted(userSent.getAccepted());
        newUser.setRole(userSent.getRole());

        return localUserRepository.save(newUser);
    }

    @Override
    public LocalUser editUser(LocalUser localUser,
                              Long id,
                              Principal principal)
            throws Exception {

        String loggedUserName = principal.getName();
        LocalUser found = localUserRepository.findOne(id);

        if(!found
                .getLogin()
                .equals(localUserRepository
                        .findByName(loggedUserName)
                        .get()
                        .getLogin()))
        {
            throw new Exception("Cannot edit other user data");
        }

        found.setSurname(localUser.getSurname());
        found.setProducts(localUser.getProducts());
        found.setCart(localUser.getCart());
        found.setAccepted(localUser.getAccepted());
        found.setRole(localUser.getRole());

        return localUserRepository.save(found);
    }

    @Override
    public void deleteUser(Long id) {
        localUserRepository.delete(id);
    }

    @Override
    public void activateUser(Long id) {
        localUserRepository.findOne(id).setAccepted(true);
        localUserRepository.save(localUserRepository.findOne(id));
    }

    @Override
    public void deactivateUser(Long id) {
        localUserRepository.findOne(id).setAccepted(false);
        localUserRepository.save(localUserRepository.findOne(id));
    }


    @Override
    public LocalUser findOne(Long id) {
        return localUserRepository.findOne(id);
    }

    public LocalUser addCart(Long userId, Long cartId) {
        localUserRepository
                .findOne(userId)
                .setCart(cartRepository.findOne(cartId));
        return localUserRepository.save(localUserRepository.findOne(userId));
    }

    @Override
    public Optional<LocalUser> findByName(String userName) {
        return localUserRepository.findByName(userName);
    }
}