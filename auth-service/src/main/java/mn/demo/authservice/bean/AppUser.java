package mn.demo.authservice.bean;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class AppUser implements UserDetails {
    private static final long serialVersionUID = 5563547274678141515L;
    private final String username;
    private final String password;
    private Collection<? extends GrantedAuthority> authorities;
    private Boolean enabled;

    public AppUser(
            final String username,
            final String password,
            Collection<? extends GrantedAuthority> authorities,
            final Boolean enabled) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.enabled = enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
        return enabled;
    }

}
