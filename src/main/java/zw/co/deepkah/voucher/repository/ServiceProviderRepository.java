package zw.co.deepkah.voucher.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import zw.co.deepkah.voucher.document.ServiceProvider;

public interface ServiceProviderRepository extends MongoRepository<ServiceProvider,String> {
}
