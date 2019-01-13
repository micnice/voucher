package zw.co.deepkah.voucher.document;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Claim")
public class Claim extends BaseId {
            private String facilityId;
            private String beneficiaryId;
            private String voucherTypeId;
            private String salesId;

}
