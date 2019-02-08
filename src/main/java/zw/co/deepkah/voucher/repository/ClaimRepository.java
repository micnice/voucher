package zw.co.deepkah.voucher.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import zw.co.deepkah.voucher.document.BeneficiaryIdentification;
import zw.co.deepkah.voucher.document.Claim;
import zw.co.deepkah.voucher.document.ServiceProvider;

import java.util.List;

public interface ClaimRepository extends MongoRepository<Claim,String> {

    List<Claim> findByBeneficiaryIdentification(BeneficiaryIdentification beneficiaryIdentification);
    List<Claim> findBySalesId(String salesId);
    List<Claim> findByServiceProviderId(String serviceProviderId);
}
