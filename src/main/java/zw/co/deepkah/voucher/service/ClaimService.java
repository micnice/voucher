package zw.co.deepkah.voucher.service;

import zw.co.deepkah.voucher.document.BeneficiaryIdentification;
import zw.co.deepkah.voucher.document.Claim;

import java.util.List;

public interface ClaimService extends IService<Claim> {

    List<Claim> findByBeneficiaryIdentification(BeneficiaryIdentification beneficiaryIdentification);

}
