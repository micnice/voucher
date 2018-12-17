package zw.co.deepkah.voucher.document;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class ContactDetails extends BaseId {
    private String beneficiaryIdentityId;
    private ContactType contactType;
    private String contactDescription;

}
