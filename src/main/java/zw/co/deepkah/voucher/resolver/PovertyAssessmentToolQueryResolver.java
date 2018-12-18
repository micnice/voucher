package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import zw.co.deepkah.voucher.document.PovertyAssessmentTool;
import zw.co.deepkah.voucher.service.PovertyAssessmentToolService;

@Component
@AllArgsConstructor
public class PovertyAssessmentToolQueryResolver implements GraphQLQueryResolver {

    private PovertyAssessmentToolService povertyAssessmentToolService;

    public PovertyAssessmentTool getPovertyAssessmentToolBybeneficiaryIdentityId(String beneficiaryIdentityId){
        return povertyAssessmentToolService.findByBeneficiaryIdentityId(beneficiaryIdentityId);
    }
}
