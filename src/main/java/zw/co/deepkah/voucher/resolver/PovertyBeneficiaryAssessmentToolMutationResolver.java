package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import zw.co.deepkah.voucher.document.BeneficiaryAssessment;
import zw.co.deepkah.voucher.document.PovertyAssessmentTool;
import zw.co.deepkah.voucher.document.PovertyBeneficiaryAssessmentTool;
import zw.co.deepkah.voucher.dto.GeneralDto;
import zw.co.deepkah.voucher.service.BeneficiaryAssessmentService;
import zw.co.deepkah.voucher.service.PovertyAssessmentToolService;

import java.util.stream.Stream;

@Component
@AllArgsConstructor
public class PovertyBeneficiaryAssessmentToolMutationResolver implements GraphQLMutationResolver {

    private BeneficiaryAssessmentService beneficiaryAssessmentService;
    private PovertyAssessmentToolService povertyAssessmentToolService;


    public PovertyBeneficiaryAssessmentTool createPovertyBeneficiaryAssessmentTool(PovertyBeneficiaryAssessmentTool povertyBeneficiaryAssessmentTool) {
        BeneficiaryAssessment beneficiaryAssessment = new BeneficiaryAssessment();
        PovertyAssessmentTool povertyAssessmentTool = new PovertyAssessmentTool();

        povertyAssessmentTool.setBeneficiaryIdentityId(povertyBeneficiaryAssessmentTool.getBeneficiaryIdentityId());
        povertyAssessmentTool.setPat1(povertyBeneficiaryAssessmentTool.getPat1());
        povertyAssessmentTool.setPat2(povertyBeneficiaryAssessmentTool.getPat2());
        povertyAssessmentTool.setPat3(povertyBeneficiaryAssessmentTool.getPat3());
        povertyAssessmentTool.setPat4(povertyBeneficiaryAssessmentTool.getPat4());
        povertyAssessmentTool.setPat5(povertyBeneficiaryAssessmentTool.getPat5());
        povertyAssessmentTool.setPat6(povertyBeneficiaryAssessmentTool.getPat6());
        povertyAssessmentTool.setPat7(povertyBeneficiaryAssessmentTool.getPat7());
        povertyAssessmentTool.setPat8(povertyBeneficiaryAssessmentTool.getPat8());
        povertyAssessmentTool.setPat9(povertyBeneficiaryAssessmentTool.getPat9());
        povertyAssessmentTool.setPat10(povertyBeneficiaryAssessmentTool.getPat10());
        povertyAssessmentTool.setPat11(povertyBeneficiaryAssessmentTool.getPat11());

        Boolean [] pat = {povertyAssessmentTool.getPat1(),povertyAssessmentTool.getPat2(),
                povertyAssessmentTool.getPat3(),
                povertyAssessmentTool.getPat4(),
                povertyAssessmentTool.getPat5(),
                povertyAssessmentTool.getPat6(),
                povertyAssessmentTool.getPat7(),
                povertyAssessmentTool.getPat8(),
                povertyAssessmentTool.getPat9(),
                povertyAssessmentTool.getPat10(),
                povertyAssessmentTool.getPat11()};
        Long trueCount= Stream.of(pat).filter(trueBoolean -> trueBoolean.booleanValue()==Boolean.TRUE).count();
        Long falseCount = Stream.of(pat).filter(falseBoolean -> falseBoolean.booleanValue()==Boolean.FALSE).count();
        povertyAssessmentTool.setFalseCount(falseCount);
        povertyAssessmentTool.setTrueCount(trueCount);


        povertyAssessmentToolService.save(povertyAssessmentTool);

        //------------------------------------------------------------------------------------------
        beneficiaryAssessment.setLatitude(povertyBeneficiaryAssessmentTool.getLatitude());
        beneficiaryAssessment.setLongitude(povertyBeneficiaryAssessmentTool.getLongitude());
        beneficiaryAssessment.setPovertyScore(povertyAssessmentTool.getTrueCount());
        beneficiaryAssessment.setPregnancyStatus(povertyBeneficiaryAssessmentTool.getPregnancyStatus());
        beneficiaryAssessmentService.save(beneficiaryAssessment);
        //----------------------------------------------------------------------------------------
       return povertyBeneficiaryAssessmentTool;

    }
}
