package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import zw.co.deepkah.voucher.document.BeneficiaryIdentification;
import zw.co.deepkah.voucher.service.BeneficiaryIdentificationService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Component
@AllArgsConstructor
public class BeneficiaryIdentificationQueryResolver implements GraphQLQueryResolver {

    private BeneficiaryIdentificationService beneficiaryIdentificationService;


    public List<BeneficiaryIdentification>  getLMPList(String lmp){
        LocalDate localDate = LocalDate.parse(lmp);
       return beneficiaryIdentificationService.findAllByLmp(localDate);
       }

       public BeneficiaryIdentification getByIdentificationNumber(String identityNumber){
        return beneficiaryIdentificationService.findByIdentificationNumber(identityNumber);
       }

       public List<BeneficiaryIdentification> trackBeneficiary(String identificationNumber,String firstName,String lastName){

        return beneficiaryIdentificationService.trackBeneficiary(identificationNumber,firstName,lastName);
       }


       public  List<BeneficiaryIdentification> getBeneficiaryIdentificationList(){

        return beneficiaryIdentificationService.findAll().get();
       }

       public List<BeneficiaryIdentification> getIdentificationNotAssessed(){

        return beneficiaryIdentificationService.getIdentificationNotAssessed();
       }

       public List<BeneficiaryIdentification> getIdentificationAssessedAndPassed(){

        return beneficiaryIdentificationService.getIdentificationAssessedAndPassed();
       }
}
