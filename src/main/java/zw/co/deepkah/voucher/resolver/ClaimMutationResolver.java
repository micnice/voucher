package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import zw.co.deepkah.voucher.document.*;
import zw.co.deepkah.voucher.dto.ClaimDto;
import zw.co.deepkah.voucher.service.*;

import java.util.Optional;

@AllArgsConstructor
@Component
public class ClaimMutationResolver implements GraphQLMutationResolver {

    private ClaimService claimService;
    private VoucherTypeService voucherTypeService;
    private FacilityService facilityService;
    private BeneficiaryIdentificationService beneficiaryIdentificationService;
    private SalesService salesService;

    public Claim createClaim(ClaimDto claimDto){
        Claim claim = new Claim();
        BeneficiaryIdentification beneficiaryIdentification = beneficiaryIdentificationService.getOne(claimDto.getBeneficiaryIdentification()).get();
             claim.setBeneficiaryIdentification(beneficiaryIdentification);

             Facility facility = facilityService.getOne(claimDto.getFacility()).get();
          claim.setFacility(facility);
          VoucherType voucherType = voucherTypeService.getOne(claimDto.getVoucherType()).get();
          claim.setVoucherType(voucherType);
          Sales sales = salesService.getOne(claimDto.getSales()).get();
          claim.setSales(sales);
          return claimService.save(claim);


    }


    public Claim updateClaim(ClaimDto claimDto, Optional<String> claimId){
        Claim claim = new Claim();

            claim = claimService.getOne(claimId.get()).get();
            claim.setBeneficiaryIdentification(new BeneficiaryIdentification(claimDto.getBeneficiaryIdentification()));

            Facility facility = facilityService.getOne(claimDto.getFacility()).get();
            claim.setFacility(facility);
            VoucherType voucherType = voucherTypeService.getOne(claimDto.getVoucherType()).get();
            claim.setVoucherType(voucherType);
            Sales sales = salesService.getOne(claimDto.getSales()).get();
            claim.setSales(sales);

        return claimService.save(claim);
    }
}
