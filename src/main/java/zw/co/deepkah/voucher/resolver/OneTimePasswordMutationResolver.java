package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import zw.co.deepkah.voucher.document.BeneficiaryIdentification;
import zw.co.deepkah.voucher.document.City;
import zw.co.deepkah.voucher.document.OneTimePassword;
import zw.co.deepkah.voucher.document.Sales;
import zw.co.deepkah.voucher.dto.CityDto;
import zw.co.deepkah.voucher.service.BeneficiaryIdentificationService;
import zw.co.deepkah.voucher.service.CityService;
import zw.co.deepkah.voucher.service.SalesService;
import zw.co.deepkah.voucher.util.GeneralUtils;
import zw.co.deepkah.voucher.util.PhoneNumberFormatter;
import zw.co.deepkah.voucher.util.RestTemplateUtil;
import zw.co.deepkah.voucher.util.TextMessageUtil;

import java.util.Optional;
import java.util.Random;

@Component
@AllArgsConstructor
public class OneTimePasswordMutationResolver implements GraphQLMutationResolver {

    private SalesService salesService;
    private BeneficiaryIdentificationService beneficiaryIdentificationService;

    public OneTimePassword createTenDollarOTP(String saleID){
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

        return new OneTimePassword(sale.getTenDollarOTP(),sale.getId());
    }

    public OneTimePassword createTwentyDollarOTP(String saleID){
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
        return new OneTimePassword(sale.getTenDollarOTP(),sale.getId());
    }
}
