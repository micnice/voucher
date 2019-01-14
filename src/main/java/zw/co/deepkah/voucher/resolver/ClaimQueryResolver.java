package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import zw.co.deepkah.voucher.document.BeneficiaryIdentification;
import zw.co.deepkah.voucher.document.Claim;
import zw.co.deepkah.voucher.service.BeneficiaryIdentificationService;
import zw.co.deepkah.voucher.service.ClaimService;

import java.util.List;

@AllArgsConstructor
@Component
public class ClaimQueryResolver implements GraphQLQueryResolver {

    private ClaimService claimService;
    private BeneficiaryIdentificationService beneficiaryIdentificationService;


    public List<Claim> getClaimList(){
        return claimService.findAll().get();
    }

    public List<Claim> findByBeneficiaryId(String beneficiaryIdentificationId){

        BeneficiaryIdentification beneficiaryIdentification = beneficiaryIdentificationService.getOne(beneficiaryIdentificationId).get();
        return claimService.findByBeneficiaryIdentification(beneficiaryIdentification);
    }
}
