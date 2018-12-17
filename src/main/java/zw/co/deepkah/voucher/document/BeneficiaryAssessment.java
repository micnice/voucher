package zw.co.deepkah.voucher.document;

import lombok.Data;

@Data
public class BeneficiaryAssessment extends BaseId {
   private PregnacyStatus pregnacyStatus;
   private Double povertyScore;
   private String latitude;
   private String longitude;

}


