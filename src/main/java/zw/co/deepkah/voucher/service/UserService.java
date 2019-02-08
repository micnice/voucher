package zw.co.deepkah.voucher.service;

import org.springframework.security.core.userdetails.UserDetails;
import zw.co.deepkah.voucher.document.security.User;

public interface UserService extends IService<User> {

    User findByUsername(String username);
    User findByEmail(String email);
    User findByEmailOrUsername(String email,String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);



    boolean existsByEmailOrUsername(String email,String username);


}
