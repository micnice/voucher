package zw.co.deepkah.voucher.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import zw.co.deepkah.voucher.document.BeneficiaryAssessment;

import java.util.List;

public interface BeneficiaryAssessmentRepository extends MongoRepository<BeneficiaryAssessment,String> {

    BeneficiaryAssessment getByBeneficiaryIdentityId(String beneficiaryIdentityId);

    List<BeneficiaryAssessment> findAllByBeneficiaryIdentityId();

    boolean existsByBeneficiaryIdentityId(String beneficiaryIdentityId);
}
