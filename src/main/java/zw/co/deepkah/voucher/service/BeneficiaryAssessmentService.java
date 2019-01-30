package zw.co.deepkah.voucher.service;

import zw.co.deepkah.voucher.document.BeneficiaryAssessment;

import java.util.List;

public interface BeneficiaryAssessmentService extends IService<BeneficiaryAssessment> {

    BeneficiaryAssessment findByBeneficiaryIdentityId(String beneficiaryIdentityId);
    boolean existsByBeneficiaryIdentityId(String beneficiaryIdentityId);
    List<BeneficiaryAssessment> getAllBySaleIsFalse();
}
