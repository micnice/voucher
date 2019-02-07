package zw.co.deepkah.voucher.document.security;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import zw.co.deepkah.voucher.document.BaseId;
import java.util.Set;

@Document(collection = "user")
@Data
public class User extends BaseId {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private Set<Roles> rolesSet;



}
