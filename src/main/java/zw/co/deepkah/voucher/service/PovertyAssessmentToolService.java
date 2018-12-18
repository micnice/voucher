package zw.co.deepkah.voucher.service;

import zw.co.deepkah.voucher.document.PovertyAssessmentTool;

public interface PovertyAssessmentToolService extends IService<PovertyAssessmentTool> {
    PovertyAssessmentTool findByBeneficiaryIdentityId(String beneficiaryIdentityId);
}
