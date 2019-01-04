package zw.co.deepkah.voucher.dto;

import lombok.Data;
import zw.co.deepkah.voucher.document.security.Role;

import java.util.Set;

@Data
public class UserDto {


    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private boolean isAccountNonExpired;
    private Set<Role> roleSet;


}
