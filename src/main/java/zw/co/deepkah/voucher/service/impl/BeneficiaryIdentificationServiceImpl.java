package zw.co.deepkah.voucher.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import zw.co.deepkah.voucher.document.BeneficiaryIdentification;
import zw.co.deepkah.voucher.repository.BeneficiaryIdentificationRepository;
import zw.co.deepkah.voucher.service.BeneficiaryIdentificationService;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service

public class BeneficiaryIdentificationServiceImpl  implements BeneficiaryIdentificationService {

    private BeneficiaryIdentificationRepository beneficiaryIdentificationRepository;


    public BeneficiaryIdentificationServiceImpl(BeneficiaryIdentificationRepository beneficiaryIdentificationRepository) {
        this.beneficiaryIdentificationRepository = beneficiaryIdentificationRepository;


    }

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
        return beneficiaryIdentificationRepository.findByIsAssessedIsFalse();
    }

    @Override
    public Optional<List<BeneficiaryIdentification>> findAll() {
        return Optional.ofNullable(beneficiaryIdentificationRepository.findAll());
    }

    @Override
    public Optional<BeneficiaryIdentification> getOne(String Id) {
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
