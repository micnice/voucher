package zw.co.deepkah.voucher.message.response;

import lombok.Data;
import zw.co.deepkah.voucher.document.security.Role;

import java.util.Set;

@Data
public class UserDtoResponse {

    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private Set<Role> roleSet;
    private String token;
    private final String type = "Bearer";

}
