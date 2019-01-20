package zw.co.deepkah.voucher.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import zw.co.deepkah.voucher.document.BeneficiaryAssessment;
import zw.co.deepkah.voucher.document.BeneficiaryIdentification;
import zw.co.deepkah.voucher.document.Facility;
import zw.co.deepkah.voucher.repository.BeneficiaryAssessmentRepository;
import zw.co.deepkah.voucher.repository.BeneficiaryIdentificationRepository;
import zw.co.deepkah.voucher.service.BeneficiaryAssessmentService;
import zw.co.deepkah.voucher.service.BeneficiaryIdentificationService;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BeneficiaryIdentificationServiceImpl  implements BeneficiaryIdentificationService {

    private BeneficiaryIdentificationRepository beneficiaryIdentificationRepository;
    private BeneficiaryAssessmentService beneficiaryAssessmentService;

 @Override
    public BeneficiaryIdentification findByIdentificationNumber(String identityNumber) {
        return beneficiaryIdentificationRepository.findByIdentificationNumber(identityNumber);
    }



    @Override
    public List<BeneficiaryIdentification> findAllByLmp(LocalDate localDate) {
        return beneficiaryIdentificationRepository.findAllByLmp(localDate);
    }

    @Override
    public List<BeneficiaryIdentification> trackBeneficiary(String identificationNumber, String firstName, String lastName) {
        return beneficiaryIdentificationRepository.findByIdentificationNumberLikeOrFirstNameLikeOrLastNameLike(identificationNumber,firstName,lastName);
    }

    @Override
    public List<BeneficiaryIdentification> getIdentificationNotAssessed() {
        return beneficiaryIdentificationRepository.findByIsAssessedIsFalseOrReAssessIsTrue();
    }

    @Override
    public boolean existsByIdentificationNumber(String identityNumber) {
        return beneficiaryIdentificationRepository.existsByIdentificationNumber(identityNumber);
    }

    @Override
    public List<BeneficiaryIdentification> getIdentificationAssessedAndPassed() {
        List<BeneficiaryIdentification> assessedBeneficiaries = beneficiaryIdentificationRepository.findByIsAssessedIsTrue();

        List<BeneficiaryIdentification> passedBeneficiaries = assessedBeneficiaries.stream().filter(b->
                (beneficiaryAssessmentService.findByBeneficiaryIdentityId(b.getId())!=null
                &&beneficiaryAssessmentService.findByBeneficiaryIdentityId(b.getId()).getPovertyScore()>=3)
        &&!beneficiaryAssessmentService.findByBeneficiaryIdentityId(b.getId()).getSale()).collect(Collectors.toList());
    passedBeneficiaries.stream().forEach(b->{
        b.setPovertyScore(beneficiaryAssessmentService.findByBeneficiaryIdentityId(b.getId()).getPovertyScore());
    });
     return  passedBeneficiaries;
    }

    @Override
    public Optional<List<BeneficiaryIdentification>> findAll() {
        return Optional.ofNullable(beneficiaryIdentificationRepository.findAll());
    }

    @Override
    public Optional<BeneficiaryIdentification>  getOne(String Id) {
        return Optional.ofNullable(beneficiaryIdentificationRepository.findById(Id).get());
    }

    @Override
    public void removeById(String Id) {
          beneficiaryIdentificationRepository.deleteById(Id);
    }

    @Override
    public void remove(BeneficiaryIdentification beneficiaryIdentification) {
        beneficiaryIdentificationRepository.delete(beneficiaryIdentification);
    }

    @Override
    public BeneficiaryIdentification save(BeneficiaryIdentification beneficiaryIdentification) {
        return beneficiaryIdentificationRepository.save(beneficiaryIdentification);
    }


}
