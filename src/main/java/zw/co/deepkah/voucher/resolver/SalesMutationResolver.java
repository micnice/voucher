package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import zw.co.deepkah.voucher.document.*;
import zw.co.deepkah.voucher.dto.SalesDto;
import zw.co.deepkah.voucher.service.*;
import zw.co.deepkah.voucher.util.DateFormatter;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
public class SalesMutationResolver implements GraphQLMutationResolver {

    private SalesService salesService;
    private ServiceProviderService serviceProviderService;
    private VoucherSetService voucherSetService;
    private BeneficiaryAssessmentService beneficiaryAssessmentService;
    private BeneficiaryIdentificationService beneficiaryIdentificationService;
    private ClaimService claimService;


    public Sales createSales(SalesDto salesDto){
        Sales sales = new Sales();
        sales.setSaleDate(DateFormatter.getDateFromString(salesDto.getSaleDate()));
        sales.setSoldBy(salesDto.getSoldBy());
        sales.setVoucherSerialNumber(UUID.randomUUID().toString());
        sales.setBeneficiaryIdentityId(salesDto.getBeneficiaryIdentityId());
        VoucherSet voucherSet = voucherSetService.getOne(salesDto.getVoucherSet()).get();
        sales.setVoucherSet(voucherSet);
        Sales savedSale= salesService.save(sales);

        BeneficiaryAssessment ba = beneficiaryAssessmentService.findByBeneficiaryIdentityId(savedSale.getBeneficiaryIdentityId());
        ba.setSale(Boolean.TRUE);
        beneficiaryAssessmentService.save(ba);
        BeneficiaryIdentification bi = beneficiaryIdentificationService.getOne(salesDto.getBeneficiaryIdentityId()).get();

        try {
            for(VoucherType voucherType:voucherSet.getVoucherTypeSet()) {
                Claim claim = new Claim();
                claim.setSales(savedSale);
                claim.setVoucherType(voucherType);
                claim.setBeneficiaryIdentification(bi);
                claimService.save(claim);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return savedSale;
    }


    public Sales updateSales(SalesDto salesDto, Optional<String> salesId){
        Sales sales = new Sales();
        salesId.ifPresent(s -> {
            sales.setId(salesService.getOne(s).get().getId());
            sales.setSaleDate(DateFormatter.getDateFromString(salesDto.getSaleDate()));
            sales.setSoldBy(salesDto.getSoldBy());
            sales.setVoucherSerialNumber(salesDto.getVoucherSerialNumber());
            sales.setBeneficiaryIdentityId(salesDto.getBeneficiaryIdentityId());
            VoucherSet voucherSet = voucherSetService.getOne(salesDto.getVoucherSet()).get();
            sales.setVoucherSet(voucherSet);
        });

        return salesService.save(sales);
    }
}
