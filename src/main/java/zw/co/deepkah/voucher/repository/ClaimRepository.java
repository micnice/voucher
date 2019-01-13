package zw.co.deepkah.voucher.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import zw.co.deepkah.voucher.document.Claim;

import java.util.List;

public interface ClaimRepository extends MongoRepository<Claim,String> {

    List<Claim> findByBeneficiaryId(String beneficiaryId);
}
