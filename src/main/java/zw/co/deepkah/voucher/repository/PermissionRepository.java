package zw.co.deepkah.voucher.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import zw.co.deepkah.voucher.document.security.Permission;

public interface PermissionRepository extends MongoRepository<Permission,String> {
}
