package zw.co.deepkah.voucher.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import zw.co.deepkah.voucher.document.BeneficiaryIdentification;

import java.time.LocalDate;
import java.util.List;

public interface BeneficiaryIdentificationRepository extends MongoRepository<BeneficiaryIdentification,String> {

    BeneficiaryIdentification findByIdentificationNumber(String identityNumber);
    List<BeneficiaryIdentification> findAllByLmp(LocalDate localDate);
    List<BeneficiaryIdentification> findByIdentificationNumberLikeOrFirstNameLikeOrLastNameLike(String identificationNumber,String firstName,String lastName);
    List<BeneficiaryIdentification> findByIsAssessedIsFalseOrReAssessIsTrue();
    boolean existsByIdentificationNumber(String identityNumber);
    List<BeneficiaryIdentification> findByIsAssessedIsTrue();

}
