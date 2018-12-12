package zw.co.deepkah.voucher.document;

import lombok.Data;

@Data
public class ContactDetails extends BaseId {
    private String beneficiaryIdentityId;
    private ContactType contactType;
    private String contactDescription;

}
