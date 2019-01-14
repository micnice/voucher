package zw.co.deepkah.voucher.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import zw.co.deepkah.voucher.document.Facility;

public interface FacilityRepository extends MongoRepository<Facility,String> {

    Facility findByName(String name);

}
