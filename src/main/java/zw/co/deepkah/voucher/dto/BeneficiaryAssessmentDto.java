package zw.co.deepkah.voucher.dto;

import lombok.Data;
import zw.co.deepkah.voucher.document.PregnancyStatus;
@Data
public class BeneficiaryAssessmentDto {

    private String beneficiaryIdentityId;
    private PregnancyStatus pregnancyStatus;
    private Long povertyScore;
    private String latitude;
    private String longitude;
}
