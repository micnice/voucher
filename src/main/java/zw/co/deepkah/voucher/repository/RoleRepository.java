package zw.co.deepkah.voucher.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import zw.co.deepkah.voucher.document.security.Role;

public interface RoleRepository extends MongoRepository<Role,String> {

    Role findByName(String name);
}
