package zw.co.deepkah.voucher.service;

import zw.co.deepkah.voucher.document.security.User;

public interface UserService extends IService<User> {

    User findByUsername(String username);
    User findByEmail(String email);
    User findByEmailOrUsername(String email,String username);
}
