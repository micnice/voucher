package zw.co.deepkah.voucher.document;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class BeneficiaryAssessment extends BaseId {
   private String beneficiaryIdentityId;
   private PregnancyStatus pregnancyStatus;
   private String dateAssessed;
   private Long povertyScore;
   private String latitude;
   private String longitude;
   private String assessedBy;
   private Boolean sale = Boolean.FALSE;

}


