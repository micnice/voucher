package zw.co.deepkah.voucher.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import zw.co.deepkah.voucher.document.PovertyAssessmentTool;

public interface PovertyAssessmentToolRepository extends MongoRepository<PovertyAssessmentTool,String> {


    PovertyAssessmentTool findByBeneficiaryIdentityId(String beneficiaryIdentityId);

}
