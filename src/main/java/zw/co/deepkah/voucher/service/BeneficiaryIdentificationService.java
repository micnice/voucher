package zw.co.deepkah.voucher.service;

import zw.co.deepkah.voucher.document.BeneficiaryIdentification;

import java.time.LocalDate;
import java.util.List;

public interface BeneficiaryIdentificationService extends IService<BeneficiaryIdentification> {

    BeneficiaryIdentification findByIdentificationNumber(String identityNumber);
    List<BeneficiaryIdentification> findAllByLmp(LocalDate localDate);
    List<BeneficiaryIdentification> trackBeneficiary(String identificationNumber,String firstName,String lastName);
    List<BeneficiaryIdentification> getIdentificationNotAssessed();
}
