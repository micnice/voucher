package zw.co.deepkah.voucher.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import zw.co.deepkah.voucher.document.AddressDetails;

public interface AddressDetailsRepository extends MongoRepository<AddressDetails,String> {


}
