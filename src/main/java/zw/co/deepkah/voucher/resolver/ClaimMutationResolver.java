package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import zw.co.deepkah.voucher.document.Claim;
import zw.co.deepkah.voucher.dto.ClaimDto;
import zw.co.deepkah.voucher.service.ClaimService;

@AllArgsConstructor
@Component
public class ClaimMutationResolver implements GraphQLMutationResolver {

    private ClaimService claimService;

    public Claim createClaim(ClaimDto claimDto){
        Claim claim = new Claim();
        claim.setBeneficiaryId(claimDto.getBeneficiaryId());
        claim.setFacilityId(claimDto.getFacilityId());
        claim.setSalesId(claimDto.getSalesId());
        claim.setVoucherTypeId(claimDto.getVoucherTypeId());
        return claimService.save(claim);
    }
}
