package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import zw.co.deepkah.voucher.document.PovertyAssessmentTool;
import zw.co.deepkah.voucher.dto.PovertyAssessmentToolDto;
import zw.co.deepkah.voucher.service.PovertyAssessmentToolService;

import java.util.Optional;
import java.util.stream.Stream;

@Component
@AllArgsConstructor
public class PovertyAssessmentToolMutationResolver implements GraphQLMutationResolver {

    private PovertyAssessmentToolService povertyAssessmentToolService;

    public PovertyAssessmentTool createPovertyAssessmentTool(PovertyAssessmentToolDto povertyAssessmentToolDto){



        PovertyAssessmentTool povertyAssessmentTool = new PovertyAssessmentTool();
        povertyAssessmentTool.setBeneficiaryIdentityId(povertyAssessmentToolDto.getBeneficiaryIdentityId());
        povertyAssessmentTool.setPat1(povertyAssessmentToolDto.getPat1());
        povertyAssessmentTool.setPat2(povertyAssessmentToolDto.getPat2());
        povertyAssessmentTool.setPat3(povertyAssessmentToolDto.getPat3());
        povertyAssessmentTool.setPat4(povertyAssessmentToolDto.getPat4());
        povertyAssessmentTool.setPat5(povertyAssessmentToolDto.getPat5());
        povertyAssessmentTool.setPat6(povertyAssessmentToolDto.getPat6());
        povertyAssessmentTool.setPat7(povertyAssessmentToolDto.getPat7());
        povertyAssessmentTool.setPat8(povertyAssessmentToolDto.getPat8());
        povertyAssessmentTool.setPat9(povertyAssessmentToolDto.getPat9());
        povertyAssessmentTool.setPat10(povertyAssessmentToolDto.getPat10());
        povertyAssessmentTool.setPat11(povertyAssessmentToolDto.getPat11());
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


        return povertyAssessmentToolService.save(povertyAssessmentTool);
    }


    public PovertyAssessmentTool updatePovertyAssessmentTool(PovertyAssessmentToolDto povertyAssessmentToolDto, Optional<String> patId){
        PovertyAssessmentTool povertyAssessmentTool = new PovertyAssessmentTool();
        patId.ifPresent(s -> {

            povertyAssessmentTool.setId(povertyAssessmentToolService.getOne(s).get().getId());
            povertyAssessmentTool.setBeneficiaryIdentityId(povertyAssessmentToolDto.getBeneficiaryIdentityId());
            povertyAssessmentTool.setPat1(povertyAssessmentToolDto.getPat1());
            povertyAssessmentTool.setPat2(povertyAssessmentToolDto.getPat2());
            povertyAssessmentTool.setPat3(povertyAssessmentToolDto.getPat3());
            povertyAssessmentTool.setPat4(povertyAssessmentToolDto.getPat4());
            povertyAssessmentTool.setPat5(povertyAssessmentToolDto.getPat5());
            povertyAssessmentTool.setPat6(povertyAssessmentToolDto.getPat6());
            povertyAssessmentTool.setPat7(povertyAssessmentToolDto.getPat7());
            povertyAssessmentTool.setPat8(povertyAssessmentToolDto.getPat8());
            povertyAssessmentTool.setPat9(povertyAssessmentToolDto.getPat9());
            povertyAssessmentTool.setPat10(povertyAssessmentToolDto.getPat10());
            povertyAssessmentTool.setPat11(povertyAssessmentToolDto.getPat11());
            });

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

        return povertyAssessmentToolService.save(povertyAssessmentTool);
    }
}
