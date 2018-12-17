package zw.co.deepkah.voucher.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import zw.co.deepkah.voucher.document.VoucherType;

public interface VoucherTypeRepository extends MongoRepository<VoucherType,String> {
    VoucherType findByName(String name);
}
