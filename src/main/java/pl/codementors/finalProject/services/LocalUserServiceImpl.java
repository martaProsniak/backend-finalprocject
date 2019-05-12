package pl.codementors.finalProject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.codementors.finalProject.models.LocalUser;
import pl.codementors.finalProject.repo.CartRepository;
import pl.codementors.finalProject.repo.LocalUserRepository;


import java.util.List;

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


    public LocalUserServiceImpl(LocalUserRepository localUserRepository) {
        this.localUserRepository = localUserRepository;
    }

    @Override
    public List<LocalUser> findAllUsers() {
        return (List<LocalUser>) localUserRepository.findAll();
    }

    @Override
    public LocalUser createUser(LocalUser localUser) {
        return localUserRepository.save(localUser);
    }

    @Override
    public LocalUser editUser(LocalUser localUser) {
        return localUserRepository.save(localUser);
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
        localUserRepository.findOne(userId).setCart(cartRepository.findOne(cartId));
        return localUserRepository.save(localUserRepository.findOne(userId));
    }
}