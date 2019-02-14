package zw.co.deepkah.voucher.document;

import lombok.Data;

@Data
public class PovertyBeneficiaryAssessmentTool {

    private String beneficiaryIdentityId;
    private PregnancyStatus pregnancyStatus;
    private Long povertyScore;
    private String dateAssessed;
    private String latitude;
    private String longitude;
    private String assessedBy;
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
