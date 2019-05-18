package pl.codementors.finalProject.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.codementors.finalProject.models.LocalUser;
import pl.codementors.finalProject.repo.LocalUserRepository;
import pl.codementors.finalProject.services.LocalUserServiceImpl;

import java.util.Optional;

@Service
public class LocalUserDetailsService implements UserDetailsService {
    @Autowired
    private LocalUserRepository localUserRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<LocalUser> localUser = localUserRepository.findByName(userName);
        if (localUser.isPresent()) {
            return new LocalUserPrincipal(localUser.get());
        }
        throw new UsernameNotFoundException(userName);
    }
}