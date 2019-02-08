package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import zw.co.deepkah.voucher.document.BeneficiaryIdentification;
import zw.co.deepkah.voucher.document.Claim;
import zw.co.deepkah.voucher.repository.ClaimRepository;
import zw.co.deepkah.voucher.service.BeneficiaryIdentificationService;
import zw.co.deepkah.voucher.service.ClaimService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Component
public class ClaimQueryResolver implements GraphQLQueryResolver {

    private ClaimService claimService;
    private BeneficiaryIdentificationService beneficiaryIdentificationService;
    private ClaimRepository claimRepository;


    public List<Claim> getClaimList(){
        return claimService.findAll().get();
    }

    public List<Claim> findByBeneficiaryId(String beneficiaryIdentificationId){

        BeneficiaryIdentification beneficiaryIdentification = beneficiaryIdentificationService.getOne(beneficiaryIdentificationId).get();
        return claimService.findByBeneficiaryIdentification(beneficiaryIdentification);
    }

    public List<Claim> getClaimsBySaleId(String saleId){

       return claimRepository.findBySalesId(saleId);
    }

    public List<Claim> claimsListByServiceProvider(Optional<String> serviceProviderId){
        List<Claim> claimList = new ArrayList<>();
        serviceProviderId.ifPresent(s -> {
            claimList.equals(claimService.findByServiceProviderId(s));
        });
        return claimList;
    }
}
