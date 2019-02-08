package zw.co.deepkah.voucher.document.security;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import zw.co.deepkah.voucher.document.BaseId;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Document(collection = "user")
@Data
@NoArgsConstructor
public class User extends BaseId implements UserDetails {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private Set<Roles> rolesSet;
    private String token;
    private List<GrantedAuthority> grantedAuthorities;


    public User(String id, String username, String token, List<GrantedAuthority> grantedAuthorities) {
        super(id);
        this.username = username;
        this.token = token;
        this.grantedAuthorities = grantedAuthorities;
    }

    public User(String username, String password, String firstName, String lastName, String email, Set<Roles> rolesSet) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.rolesSet = rolesSet;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
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
