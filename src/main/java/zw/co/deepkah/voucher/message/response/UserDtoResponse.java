package zw.co.deepkah.voucher.message.response;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import zw.co.deepkah.voucher.document.security.Role;

import java.util.List;
import java.util.Set;

@Data
public class UserDtoResponse {


    private String username;
    private List<GrantedAuthority> roleSet;
    private String token;
    private final String type = "Bearer";

}
