package zw.co.deepkah.voucher.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import zw.co.deepkah.voucher.document.BeneficiaryAssessment;
import zw.co.deepkah.voucher.repository.BeneficiaryAssessmentRepository;
import zw.co.deepkah.voucher.service.BeneficiaryAssessmentService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BeneficiaryAssessmentServiceImpl implements BeneficiaryAssessmentService {

    private BeneficiaryAssessmentRepository beneficiaryAssessmentRepository;
    @Override
    public Optional<List<BeneficiaryAssessment>> findAll() {
        return Optional.ofNullable(beneficiaryAssessmentRepository.findAll());
    }

    @Override
    public Optional<BeneficiaryAssessment> getOne(String Id) {
        return Optional.ofNullable(beneficiaryAssessmentRepository.findById(Id).get());
    }

    @Override
    public void removeById(String Id) {
         beneficiaryAssessmentRepository.deleteById(Id);
    }

    @Override
    public void remove(BeneficiaryAssessment beneficiaryAssessment) {
   beneficiaryAssessmentRepository.delete(beneficiaryAssessment);
    }

    @Override
    public BeneficiaryAssessment save(BeneficiaryAssessment beneficiaryAssessment) {
        return beneficiaryAssessmentRepository.save(beneficiaryAssessment);
    }

    @Override
    public BeneficiaryAssessment findByBeneficiaryIdentityId(String beneficiaryIdentityId) {
        return beneficiaryAssessmentRepository.getByBeneficiaryIdentityId(beneficiaryIdentityId);
    }

    @Override
    public boolean existsByBeneficiaryIdentityId(String beneficiaryIdentityId) {
        return beneficiaryAssessmentRepository.existsByBeneficiaryIdentityId(beneficiaryIdentityId);
    }
}
