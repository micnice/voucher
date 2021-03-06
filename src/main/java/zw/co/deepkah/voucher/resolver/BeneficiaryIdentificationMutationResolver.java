package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import graphql.GraphQLException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import zw.co.deepkah.voucher.document.BeneficiaryIdentification;
import zw.co.deepkah.voucher.dto.BeneficiaryIdentificationDto;
import zw.co.deepkah.voucher.service.BeneficiaryIdentificationService;
import zw.co.deepkah.voucher.util.DateFormatter;
import java.util.Optional;

@Component
@AllArgsConstructor
public class BeneficiaryIdentificationMutationResolver implements GraphQLMutationResolver {

    private BeneficiaryIdentificationService beneficiaryIdentificationService;


    public BeneficiaryIdentification createBeneficiaryIdentification(BeneficiaryIdentificationDto beneficiaryIdentificationDto){
        BeneficiaryIdentification beneficiaryIdentification = new BeneficiaryIdentification();
        beneficiaryIdentification.setFirstName(beneficiaryIdentificationDto.getFirstName());
        beneficiaryIdentification.setLastName(beneficiaryIdentificationDto.getLastName());
        beneficiaryIdentification.setBirthDate(beneficiaryIdentificationDto.getBirthDate());
        beneficiaryIdentification.setEducationStatus(beneficiaryIdentificationDto.getEducationStatus());
        beneficiaryIdentification.setIdentificationNumber(beneficiaryIdentificationDto.getIdentificationNumber());
        beneficiaryIdentification.setLmp(beneficiaryIdentificationDto.getLmp());
        beneficiaryIdentification.setLatitude(beneficiaryIdentificationDto.getLatitude());
        beneficiaryIdentification.setLongitude(beneficiaryIdentificationDto.getLongitude());
        beneficiaryIdentification.setEdd(DateFormatter.calculateEDD(beneficiaryIdentification.getLmp()));
        beneficiaryIdentification.setParity(beneficiaryIdentificationDto.getParity());
        beneficiaryIdentification.setPhoneNumber(beneficiaryIdentificationDto.getPhoneNumber());
        beneficiaryIdentification.setDataCollectionDate(beneficiaryIdentificationDto.getDataCollectionDate());
        beneficiaryIdentification.setMaritalStatus(beneficiaryIdentificationDto.getMaritalStatus());
        beneficiaryIdentification.setDataCollectedBy(beneficiaryIdentificationDto.getDataCollectedBy());

       boolean identityNumberExists = beneficiaryIdentificationService.existsByIdentificationNumber(beneficiaryIdentification.getIdentificationNumber());

               if(!identityNumberExists) {
                   return beneficiaryIdentificationService.save(beneficiaryIdentification);
               }
               else {
                   try {
                       throw new GraphQLException("Duplicate record");
                   } catch (Exception e) {
                       e.printStackTrace();
                   }
               }
               return beneficiaryIdentification;
    }


    public BeneficiaryIdentification updateBeneficiaryIdentification(BeneficiaryIdentificationDto beneficiaryIdentificationDto, Optional<String> beneficiaryIdentityId){
        BeneficiaryIdentification beneficiaryIdentification = new BeneficiaryIdentification();

        if(beneficiaryIdentityId.isPresent()){
            beneficiaryIdentification = beneficiaryIdentificationService.getOne(beneficiaryIdentityId.get()).get();
            beneficiaryIdentification.setFirstName(beneficiaryIdentificationDto.getFirstName());
            beneficiaryIdentification.setLastName(beneficiaryIdentificationDto.getLastName());
            beneficiaryIdentification.setBirthDate(beneficiaryIdentificationDto.getBirthDate());
            beneficiaryIdentification.setEducationStatus(beneficiaryIdentificationDto.getEducationStatus());
            beneficiaryIdentification.setIdentificationNumber(beneficiaryIdentificationDto.getIdentificationNumber());
            beneficiaryIdentification.setLmp(beneficiaryIdentificationDto.getLmp());
            beneficiaryIdentification.setLatitude(beneficiaryIdentificationDto.getLatitude());
            beneficiaryIdentification.setLongitude(beneficiaryIdentificationDto.getLongitude());
            beneficiaryIdentification.setParity(beneficiaryIdentificationDto.getParity());
            beneficiaryIdentification.setDataCollectionDate(beneficiaryIdentificationDto.getDataCollectionDate());
            beneficiaryIdentification.setMaritalStatus(beneficiaryIdentificationDto.getMaritalStatus());

        }

     return beneficiaryIdentificationService.save(beneficiaryIdentification);
    }

}
