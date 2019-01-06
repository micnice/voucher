package zw.co.deepkah.voucher.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import zw.co.deepkah.voucher.document.Sales;

public interface SalesRepository extends MongoRepository<Sales,String> {

    Sales findByVoucherSerialNumber(String voucherSerialNumber);
}
