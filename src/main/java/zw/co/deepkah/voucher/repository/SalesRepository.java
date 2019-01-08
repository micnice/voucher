package zw.co.deepkah.voucher.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import zw.co.deepkah.voucher.document.Sales;

import java.util.List;

public interface SalesRepository extends MongoRepository<Sales,String> {

    Sales findByVoucherSerialNumber(String voucherSerialNumber);
    List< Sales> findAllByBeneficiaryIdentityId(String beneficiaryIdentityId);
}
