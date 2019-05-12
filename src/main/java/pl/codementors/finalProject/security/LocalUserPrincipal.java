package pl.codementors.finalProject.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.codementors.finalProject.models.LocalUser;
import pl.codementors.finalProject.models.LocalUserRole;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

public class LocalUserPrincipal implements UserDetails {

    /**
     * field local user is set up by constructor.
     * then field localuser is used in getAuthorities
     */
    private LocalUser localUser;

    public LocalUserPrincipal(LocalUser localUser) {
        this.localUser = localUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (localUser.getRole() == LocalUserRole.ADMIN) {
                 return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"),
                         new SimpleGrantedAuthority("ROLE_USER"));
            } else if (localUser.getRole() == LocalUserRole.USER) {
                 return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
             } else {
                 return Collections.EMPTY_LIST;
             }
    }

    @Override
    public String getPassword() {
        return this.localUser.getPassword();
    }

    @Override
    public String getUsername() {
        return localUser.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}