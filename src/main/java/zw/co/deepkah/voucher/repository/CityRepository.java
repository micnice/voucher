package zw.co.deepkah.voucher.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import zw.co.deepkah.voucher.document.City;

public interface CityRepository extends MongoRepository<City,String> {

    City findByName(String name);
}
