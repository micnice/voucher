package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import zw.co.deepkah.voucher.document.*;
import zw.co.deepkah.voucher.dto.SalesDto;
import zw.co.deepkah.voucher.service.*;
import zw.co.deepkah.voucher.util.*;

import java.util.Date;
import java.util.Optional;
import java.util.Random;
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
        BeneficiaryIdentification bi = beneficiaryIdentificationService.getOne(salesDto.getBeneficiaryIdentityId()).get();
        Sales sales = new Sales();
        sales.setSaleDate(DateFormatter.getDateFromString(salesDto.getSaleDate()));
        sales.setSoldBy(salesDto.getSoldBy());
        sales.setVoucherSerialNumber(UUID.randomUUID().toString());
        sales.setBeneficiaryIdentityId(salesDto.getBeneficiaryIdentityId());
        VoucherSet voucherSet = voucherSetService.getOne(salesDto.getVoucherSet()).get();
        sales.setVoucherSet(voucherSet);
        Sales savedSale= salesService.save(sales);

        try{
            if(bi.getPhoneNumber()!=null) {
                MultiValueMap<String, String> map = TextMessageUtil.getTxtMessageUtils();
                Date edd = DateFormatter.calculateEDD(bi.getLmp());
                String message = TextMessageUtil.getVoucherSaleNotificationMessage(bi.getFirstName() + " " + bi.getLastName(),edd);
                map.add("mobile", PhoneNumberFormatter.formatPhoneNumber(bi.getPhoneNumber()));
                map.add("message", message);
                RestTemplateUtil.postData(map);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        BeneficiaryAssessment ba = beneficiaryAssessmentService.findByBeneficiaryIdentityId(savedSale.getBeneficiaryIdentityId());
        ba.setSale(Boolean.TRUE);
        beneficiaryAssessmentService.save(ba);


        try {
            for(VoucherType voucherType:voucherSet.getVoucherTypeSet()) {
                Claim claim = new Claim();
                claim.setSales(savedSale);
                if(claim.getVoucherType().getName().contains("Token")){
                    claim.setHasOTP(Boolean.TRUE);
                }
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

    public String createTenDollarOTP(String saleID){
     Sales sale = salesService.getOne(saleID).get();
     Random rnd = new Random();
     StringBuilder sb =new StringBuilder(rnd.nextInt(GeneralUtils.alphabet.length()));
     sb.append(1000+rnd.nextInt(8999));
     sale.setTenDollarOTP(sb.toString());
     salesService.save(sale);
        BeneficiaryIdentification beneficiaryIdentification = beneficiaryIdentificationService.getOne(sale.getBeneficiaryIdentityId()).get();
        MultiValueMap<String, String> map = TextMessageUtil.getTxtMessageUtils();
        String message = TextMessageUtil.getOTP(beneficiaryIdentification.getFirstName()+" "+beneficiaryIdentification.getLastName()
                , "10",sale.getTenDollarOTP());
        map.add("mobile", PhoneNumberFormatter.formatPhoneNumber(beneficiaryIdentification.getPhoneNumber()));
        map.add("message", message);
        RestTemplateUtil.postData(map);
     return sb.toString();
    }

    public String createTwentyDollarOTP(String saleID){
        Sales sale = salesService.getOne(saleID).get();
        Random rnd = new Random();
        StringBuilder sb =new StringBuilder(rnd.nextInt(GeneralUtils.alphabet.length()));
        sb.append(1000+rnd.nextInt(8999));
        sale.setTwentyDollarOTP(sb.toString());
      Sales savedSale =salesService.save(sale);
      if(savedSale!=null){
          BeneficiaryIdentification beneficiaryIdentification = beneficiaryIdentificationService.getOne(sale.getBeneficiaryIdentityId()).get();
          MultiValueMap<String, String> map = TextMessageUtil.getTxtMessageUtils();
          String message = TextMessageUtil.getOTP(beneficiaryIdentification.getFirstName()+" "+beneficiaryIdentification.getLastName()
                  , "20",sale.getTwentyDollarOTP());
          map.add("mobile", PhoneNumberFormatter.formatPhoneNumber(beneficiaryIdentification.getPhoneNumber()));
          map.add("message", message);
          RestTemplateUtil.postData(map);

      }
        return sb.toString();
    }
}
