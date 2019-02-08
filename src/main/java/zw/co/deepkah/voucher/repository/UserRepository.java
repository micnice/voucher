package zw.co.deepkah.voucher.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import zw.co.deepkah.voucher.document.security.User;

public interface UserRepository extends MongoRepository<User,String> {

    User findByUsername(String username);
    User findByEmail(String email);
    User findByEmailOrUsername(String email,String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsByEmailOrUsername(String email,String username);
}
