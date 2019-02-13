package zw.co.deepkah.voucher.dto;

import lombok.Data;
import zw.co.deepkah.voucher.document.security.Role;

import java.util.Set;

@Data
public class SignInDto {


    private String username;
    private String token;
    private String type = "Bearer";
    private Set<Role> roleSet;


}
