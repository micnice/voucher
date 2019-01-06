package zw.co.deepkah.voucher.document;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "poverty_assessment_tool")
public class PovertyAssessmentTool extends BaseId {

    private String beneficiaryIdentityId;
    private LocalDate dateAssesed;
    private Boolean pat1;
    private Boolean pat2;
    private Boolean pat3;
    private Boolean pat4;
    private Boolean pat5;
    private Boolean pat6;
    private Boolean pat7;
    private Boolean pat8;
    private Boolean pat9;
    private Boolean pat10;
    private Boolean pat11;
    private Long trueCount;
    private Long falseCount;


}
