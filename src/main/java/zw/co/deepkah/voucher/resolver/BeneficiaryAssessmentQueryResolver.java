package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import zw.co.deepkah.voucher.document.BeneficiaryAssessment;
import zw.co.deepkah.voucher.service.BeneficiaryAssessmentService;

import java.util.List;

@Component
@AllArgsConstructor
public class BeneficiaryAssessmentQueryResolver implements GraphQLQueryResolver {
    private BeneficiaryAssessmentService beneficiaryAssessmentService;


    public List<BeneficiaryAssessment> beneficiaryAssessmentList(){
        return beneficiaryAssessmentService.findAll().get();
    }

    public BeneficiaryAssessment beneficiaryAssessmentByBeneficiaryIdentityId(String beneficiaryIdentityId){
        return beneficiaryAssessmentService.findByBeneficiaryIdentityId(beneficiaryIdentityId);
    }

    public  BeneficiaryAssessment beneficiaryAssessmentById(String beneficiaryAssessmentId){
        return beneficiaryAssessmentService.getOne(beneficiaryAssessmentId).get();
    }
}
