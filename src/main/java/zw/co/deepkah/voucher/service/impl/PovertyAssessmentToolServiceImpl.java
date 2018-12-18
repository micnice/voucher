package zw.co.deepkah.voucher.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import zw.co.deepkah.voucher.document.PovertyAssessmentTool;
import zw.co.deepkah.voucher.repository.PovertyAssessmentToolRepository;
import zw.co.deepkah.voucher.service.PovertyAssessmentToolService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PovertyAssessmentToolServiceImpl implements PovertyAssessmentToolService {

    private PovertyAssessmentToolRepository povertyAssessmentToolRepository;

    @Override
    public Optional<List<PovertyAssessmentTool>> findAll() {
        return Optional.ofNullable(povertyAssessmentToolRepository.findAll());
    }

    @Override
    public Optional<PovertyAssessmentTool> getOne(String Id) {
        return Optional.ofNullable(povertyAssessmentToolRepository.findById(Id).get());
    }

    @Override
    public void removeById(String Id) {
          povertyAssessmentToolRepository.deleteById(Id);
    }

    @Override
    public void remove(PovertyAssessmentTool povertyAssessmentTool) {
           povertyAssessmentToolRepository.delete(povertyAssessmentTool);
    }

    @Override
    public PovertyAssessmentTool save(PovertyAssessmentTool povertyAssessmentTool) {
        return povertyAssessmentToolRepository.save(povertyAssessmentTool);
    }

    @Override
    public PovertyAssessmentTool findByBeneficiaryIdentityId(String beneficiaryIdentityId) {
        return povertyAssessmentToolRepository.findByBeneficiaryIdentityId(beneficiaryIdentityId);
    }
}
