package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import graphql.GraphQLException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import zw.co.deepkah.voucher.document.BeneficiaryAssessment;
import zw.co.deepkah.voucher.dto.BeneficiaryAssessmentDto;
import zw.co.deepkah.voucher.service.BeneficiaryAssessmentService;

import java.util.Optional;

@Component
@AllArgsConstructor
public class BeneficiaryAssessmentMutationResolver implements GraphQLMutationResolver {

    private BeneficiaryAssessmentService beneficiaryAssessmentService;


    public BeneficiaryAssessment createBeneficiaryAssessment(BeneficiaryAssessmentDto beneficiaryAssessmentDto){
        BeneficiaryAssessment beneficiaryAssessment = new BeneficiaryAssessment();
        beneficiaryAssessment.setBeneficiaryIdentityId(beneficiaryAssessmentDto.getBeneficiaryIdentityId());
        beneficiaryAssessment.setLatitude(beneficiaryAssessmentDto.getLatitude());
        beneficiaryAssessment.setLongitude(beneficiaryAssessmentDto.getLongitude());
        beneficiaryAssessment.setPovertyScore(beneficiaryAssessmentDto.getPovertyScore());
        beneficiaryAssessment.setPregnancyStatus(beneficiaryAssessmentDto.getPregnancyStatus());

        boolean beneficiaryIdentityExist = beneficiaryAssessmentService.existsByBeneficiaryIdentityId(beneficiaryAssessment.getBeneficiaryIdentityId());
        if(!beneficiaryIdentityExist){

            return beneficiaryAssessmentService.save(beneficiaryAssessment);
        }else {
            try {
                throw new GraphQLException("Beneficiary Identity Exists");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return beneficiaryAssessment;

    }

    public BeneficiaryAssessment updateBeneficiaryAssessment(BeneficiaryAssessmentDto beneficiaryAssessmentDto,Optional<String> baId){
        BeneficiaryAssessment beneficiaryAssessment = new BeneficiaryAssessment();
         baId.ifPresent(s -> {
             beneficiaryAssessment.setId(beneficiaryAssessmentService.getOne(s).get().getId());
             beneficiaryAssessment.setBeneficiaryIdentityId(beneficiaryAssessmentDto.getBeneficiaryIdentityId());
             beneficiaryAssessment.setLatitude(beneficiaryAssessmentDto.getLatitude());
             beneficiaryAssessment.setLongitude(beneficiaryAssessmentDto.getLongitude());
             beneficiaryAssessment.setPovertyScore(beneficiaryAssessmentDto.getPovertyScore());
             beneficiaryAssessment.setPregnancyStatus(beneficiaryAssessmentDto.getPregnancyStatus());
             });
        return beneficiaryAssessmentService.save(beneficiaryAssessment);
    }
}
