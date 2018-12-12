package zw.co.deepkah.voucher.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import zw.co.deepkah.voucher.document.ContactDetails;

public interface ContactDetailsRepository extends MongoRepository<ContactDetails,String> {
}
