package zw.co.deepkah.voucher.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import zw.co.deepkah.voucher.document.Claim;
import zw.co.deepkah.voucher.repository.ClaimRepository;
import zw.co.deepkah.voucher.service.ClaimService;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ClaimServiceImpl implements ClaimService {

    private ClaimRepository claimRepository;

    @Override
    public Optional<List<Claim>> findAll() {
        return Optional.ofNullable(claimRepository.findAll());
    }

    @Override
    public Optional<Claim> getOne(String Id) {
        return Optional.ofNullable(claimRepository.findById(Id).get());
    }

    @Override
    public void removeById(String Id) {
        claimRepository.deleteById(Id);
    }

    @Override
    public void remove(Claim claim) {
           claimRepository.delete(claim);
    }

    @Override
    public Claim save(Claim claim) {
        return claimRepository.save(claim);
    }

    @Override
    public List<Claim> findByBeneficiaryId(String beneficiaryId) {
        return claimRepository.findByBeneficiaryId(beneficiaryId);
    }
}
