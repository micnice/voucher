package zw.co.deepkah.voucher.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import zw.co.deepkah.voucher.document.BeneficiaryAssessment;

public interface BeneficiaryAssessmentRepository extends MongoRepository<BeneficiaryAssessment,String> {

    BeneficiaryAssessment findByBeneficiaryIdentityId(String beneficiaryIdentityId);
}
