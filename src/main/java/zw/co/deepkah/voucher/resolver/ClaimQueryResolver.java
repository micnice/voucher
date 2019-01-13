package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import zw.co.deepkah.voucher.document.Claim;
import zw.co.deepkah.voucher.service.ClaimService;

import java.util.List;

@AllArgsConstructor
@Component
public class ClaimQueryResolver implements GraphQLQueryResolver {

    private ClaimService claimService;


    private List<Claim> getClaimList(){
        return claimService.findAll().get();
    }

    private List<Claim> findByBeneficiaryId(String beneficiaryId){
        return claimService.findByBeneficiaryId(beneficiaryId);
    }
}
