package zw.co.deepkah.voucher.document;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class AddressDetails extends BaseId {

    private String beneficiaryIdentificationId;
    private AddressType addressType;
    private String addressDescription;

}
