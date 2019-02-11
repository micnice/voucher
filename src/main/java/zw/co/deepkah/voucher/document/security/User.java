package zw.co.deepkah.voucher.document.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import zw.co.deepkah.voucher.document.BaseId;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Document(collection = "user")
@Data
@NoArgsConstructor

public class User extends BaseId {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private Set<Role> roleSet;



    public User(String firstName, String lastName, String username, String email, String encode) {
        this.firstName = firstName;
        this.lastName=lastName;
        this.username=username;
        this.email=email;
        this.password=encode;
    }
}
