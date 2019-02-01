package zw.co.deepkah.voucher.document;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class BeneficiaryAssessment extends BaseId {
   private String beneficiaryIdentityId;
   private PregnancyStatus pregnancyStatus;
   private Date dateAssessed;
   private Long povertyScore;
   private String latitude;
   private String longitude;
   private Boolean sale = Boolean.FALSE;

}


