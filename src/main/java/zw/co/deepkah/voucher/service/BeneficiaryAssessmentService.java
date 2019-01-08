package zw.co.deepkah.voucher.service;

import zw.co.deepkah.voucher.document.BeneficiaryAssessment;

public interface BeneficiaryAssessmentService extends IService<BeneficiaryAssessment> {

    BeneficiaryAssessment findByBeneficiaryIdentityId(String beneficiaryIdentityId);
    boolean existsByBeneficiaryIdentityId(String beneficiaryIdentityId);
}
