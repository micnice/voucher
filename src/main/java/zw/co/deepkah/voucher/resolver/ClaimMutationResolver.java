package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import zw.co.deepkah.voucher.document.*;
import zw.co.deepkah.voucher.dto.ClaimDto;
import zw.co.deepkah.voucher.service.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import static zw.co.deepkah.voucher.util.DateFormatter.getFormmatedNormalFormat;

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


    public Claim redeemClaim(String serviceProviderId,Optional<String> claimId,String processedBy){

      Claim claim = new Claim();
       if(claimId.isPresent()) {
           claim = claimService.getOne(claimId.get()).get();

  if (!claim.getRedeemed()){
               claim.setProcessedBy(processedBy);
               claim.setRedeemed(Boolean.TRUE);
               claim.setRedemptionDate(getFormmatedNormalFormat(LocalDate.now()));
               Sales sale = salesService.getOne(claim.getSales().getId()).get();

               if(claim.getVoucherType().getName().trim().contains("ANC 1st".trim())){
                 sale.setAncVisitOneDate(claim.getRedemptionDate());
                   salesService.save(sale);
               }if(claim.getVoucherType().getName().trim().contains("ANC 2nd".trim())){
                   sale.setAncVisitTwoDate(claim.getRedemptionDate());
                   salesService.save(sale);
               }
               if(claim.getVoucherType().getName().trim().contains("ANC 3rd".trim())){
                   sale.setAncVisitThreeDate(claim.getRedemptionDate());
                   salesService.save(sale);
               }
               if(claim.getVoucherType().getName().trim().contains("ANC 4th".trim())){
                   sale.setAncVisitFourDate(claim.getRedemptionDate());
                   salesService.save(sale);
               }
               if(claim.getVoucherType().getName().trim().contains("PNC 1st".trim())){
                   sale.setPnc7DaysVisitDate(claim.getRedemptionDate());
                   salesService.save(sale);
               }
               if(claim.getVoucherType().getName().trim().contains("PNC 2".trim())){
                   sale.setPnc6weeksVisitDate(claim.getRedemptionDate());
                   salesService.save(sale);
               }
               if(claim.getVoucherType().getName().trim().contains("Delivery".trim())
                       ||claim.getVoucherType().getName().trim().contains("Caesarean".trim())){
                   sale.setDateOfDelivery(claim.getRedemptionDate());
                   salesService.save(sale);
               }


           claim.setServiceProvider(serviceProviderService.getOne(serviceProviderId).get());

           return claimService.save(claim);
       }
       }
       return claim;

    }
}

