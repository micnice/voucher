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
    private BeneficiaryIdentificationService beneficiaryIdentificationService;
    private SalesService salesService;
    private ServiceProviderService serviceProviderService;

    public Claim createClaim(ClaimDto claimDto){
        Claim claim = new Claim();
        BeneficiaryIdentification beneficiaryIdentification = beneficiaryIdentificationService.getOne(claimDto.getBeneficiaryIdentification()).get();
             claim.setBeneficiaryIdentification(beneficiaryIdentification);
             ServiceProvider serviceProvider = serviceProviderService.getOne(claimDto.getServiceProvider()).get();
             claim.setServiceProvider(serviceProvider);
             VoucherType voucherType = voucherTypeService.getOne(claimDto.getVoucherType()).get();
            claim.setVoucherType(voucherType);
            Sales sales = salesService.getOne(claimDto.getSales()).get();
            claim.setSales(sales);
          return claimService.save(claim);


    }


    public Claim updateClaim(ClaimDto claimDto, Optional<String> claimId){
        Claim claim = new Claim();
        claimId.ifPresent(s -> {
            claim.equals(claimService.getOne(claimId.get()).get());
            BeneficiaryIdentification beneficiaryIdentification = beneficiaryIdentificationService.getOne(claimDto.getBeneficiaryIdentification()).get();
            claim.setBeneficiaryIdentification(beneficiaryIdentification);
            ServiceProvider serviceProvider = serviceProviderService.getOne(claimDto.getServiceProvider()).get();
            claim.setServiceProvider(serviceProvider);
            VoucherType voucherType = voucherTypeService.getOne(claimDto.getVoucherType()).get();
            claim.setVoucherType(voucherType);
            Sales sales = salesService.getOne(claimDto.getSales()).get();
            claim.setSales(sales);
        });


        return claimService.save(claim);
    }
}
