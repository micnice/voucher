package zw.co.deepkah.voucher.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import zw.co.deepkah.voucher.document.VoucherSet;


public interface VoucherSetRepository extends MongoRepository<VoucherSet,String> {

    VoucherSet findByName(String name);
}
