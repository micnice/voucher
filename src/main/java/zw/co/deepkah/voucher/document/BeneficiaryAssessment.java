package zw.co.deepkah.voucher.document;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BeneficiaryAssessment extends BaseId {
   private String beneficiaryIdentityId;
   private PregnancyStatus pregnancyStatus;
   private LocalDate dateAssessed;
   private Long povertyScore;
   private String latitude;
   private String longitude;
   private Boolean sale = Boolean.FALSE;

}


