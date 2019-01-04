package zw.co.deepkah.voucher.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import zw.co.deepkah.voucher.document.Level;

public interface LevelRepository extends MongoRepository<Level,String> {
}
